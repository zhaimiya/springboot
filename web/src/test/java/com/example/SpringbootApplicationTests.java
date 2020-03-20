package com.example;

import com.example.controller.UserController;
import com.example.utils.response.CommonReturnType;
import com.example.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
	UserVo userVo = new UserVo();



	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		System.out.println("8888888");
	}

    @Test
	public void saveUser(){
		userVo.setGender(false);
		userVo.setName("Xi");
		userVo.setPhone("18888888888");
		userController.saveUser(userVo);
	}

	@Test
	public void delUser(){
		userController.delUserById(10);
	}

	@Test
	public void updateUser(){
		userVo.setId(10);
		userVo.setGender(false);
		userVo.setName("Xi");
		userVo.setPhone("16666666666");
		userController.updateUser(userVo);
	}


	@Test
	public void pageUser(){
		CommonReturnType type= userController.pageUser(new UserVo(),4,1);
		if(null != type&&null!=type.getData()){
			System.out.println(type.getData());
			System.err.println(type.getData());
		}
	}
}
