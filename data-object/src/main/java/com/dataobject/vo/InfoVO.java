package com.dataobject.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class InfoVO {

    @ExcelProperty("日期")
    private Date date;

    @ExcelProperty("新增确诊")
    private Integer newDiagnosis;

    @ExcelProperty("新增死亡")
    private Integer newDeath;



    @Override
    public String toString() {
        return "InfoVo{" +
                "date=" + date +
                ", newDiagnosis=" + newDiagnosis +
                ", newDeath=" + newDeath +
                '}';
    }
}
