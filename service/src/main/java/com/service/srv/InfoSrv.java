package com.service.srv;

import com.dataobject.entity.Info;
import com.dataobject.vo.InfoVO;

import java.util.List;


public interface InfoSrv {
    void saveInfo(Info info);
    void saveInfoBatch(List<InfoVO> infos);
    List<Info> queryInfo();
    List<Info> queryTotal();
}
