package com.dataobject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Info {
//    private Integer id;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date date;
    private Integer newDiagnosis;
    private Integer death;


}
