package com.service.srv.impl;

import com.dao.mapper.InfoMapper;
import com.dataobject.entity.Info;
import com.dataobject.vo.InfoVO;
import com.service.srv.InfoSrv;
import com.service.srv.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoSrvImpl implements InfoSrv {
    @Autowired(required = false)
    private InfoMapper infoMapper;


    @Override
    public void saveInfo(Info info) {
        infoMapper.insert(info);
    }

    @Override
    public void saveInfoBatch(List<InfoVO> infos) {
        infoMapper.insertBatch(infos);
    }

    @Override
    public List<Info> queryInfo() {
        return infoMapper.selectAll();
    }

    @Override
    public List<Info> queryTotal() {
        return infoMapper.selectTotal();
    }
}
