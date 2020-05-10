package com.web.util.excel;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dataobject.entity.Info;
import com.dataobject.vo.InfoVO;
import com.service.srv.InfoSrv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class ExcelListener extends AnalysisEventListener<InfoVO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelListener.class);

    private InfoSrv infoSrv;

    public ExcelListener() {
    }

    public ExcelListener(InfoSrv infoSrv) {
        this.infoSrv = infoSrv;
    }



    // 每隔5条存储数据库
    private static final int BATCH_COUNT = 5;
    List<InfoVO> list = new ArrayList<InfoVO>();
    Info info = new Info();

    @Override
    public void invoke(InfoVO data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}");
        list.add(data);
        System.out.println(data.toString());
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }


    private void saveData() {
        if(null == list){
            LOGGER.info("excel数据为空！");
            return;
        }
        infoSrv.saveInfoBatch(list);
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }
}
