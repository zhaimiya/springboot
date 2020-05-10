package com.example;

import com.alibaba.excel.EasyExcelFactory;
import com.dataobject.utils.response.CommonReturnType;
import com.dataobject.vo.InfoVO;
import com.dataobject.vo.UserVo;
import com.web.controller.UserController;
import com.web.util.excel.ExcelListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootApplicationTests {


    @Autowired(required = false)
    private UserController userController;

    UserVo userVo = new UserVo();

    @Test
    void contextLoads() {
        System.out.println("8888888");
    }

    @Test
    public void saveUser() {
        userVo.setGender(false);
        userVo.setName("Xi");
        userVo.setPhone("18888888888");
        userController.saveUser(userVo);
    }

    @Test
    public void delUser() {
        userController.delUserById(10);
    }

    @Test
    public void updateUser() {
        userVo.setId(10);
        userVo.setGender(false);
        userVo.setName("Xi");
        userVo.setPhone("16666666666");
        userController.updateUser(userVo);
    }


    @Test
    public void pageUser() {
        UserVo userVo = new UserVo();
        userVo.setName("xi");
        userVo.setPhone("18888888888");
        CommonReturnType type = userController.pageUser(userVo, 4, 1);
        if (null != type && null != type.getData()) {
            System.out.println(type.getData());
            System.err.println(type.getData());
        }
    }


    @Test
    public void cellDataRead() throws IOException {
//		String fileName = SpringbootApplicationTests.class.getResource("/").getPath() + "demo" + File.separator + "demo.xlsx";
//		InputStream inputStream =  new FileInputStream("D:\\coding\\springboot\\web\\src\\test\\java\\com\\example\\demo.xlsx");
        String fileName = SpringbootApplicationTests.class.getResource("/").getPath() + "demo.xlsx";

        EasyExcelFactory.read(fileName, InfoVO.class,new ExcelListener()).sheet().doRead();
    }
}
