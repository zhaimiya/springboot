package com.dao.mapper;


import com.dataobject.entity.Info;
import com.dataobject.entity.User;
import com.dataobject.vo.InfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InfoMapper {


    int insertBatch(@Param("records") List<InfoVO> records);

    int insert(Info record);

    List<Info> selectAll();

    List<Info> selectTotal();
}