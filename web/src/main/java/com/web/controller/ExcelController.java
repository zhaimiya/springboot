package com.web.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.dataobject.entity.Info;
import com.dataobject.utils.response.CommonReturnType;
import com.dataobject.vo.InfoVO;
import com.service.srv.InfoSrv;
import com.web.util.excel.ExcelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private InfoSrv infoSrv;

    @GetMapping("/import")
    public void read() {
        String fileName = ExcelController.class.getResource("/").getPath() + "demo.xlsx";
        EasyExcelFactory.read(fileName, InfoVO.class, new ExcelListener(infoSrv)).sheet().doRead();
    }

    @RequestMapping("/getinfo")
    public CommonReturnType getInfo() {
        List<Info> data = infoSrv.queryInfo();
        return CommonReturnType.sendResponse(data);
    }

    @RequestMapping("/gettotal")
    public CommonReturnType getTotal() {
        List<Info> data = infoSrv.queryTotal();
        return CommonReturnType.sendResponse(data);
    }
}
