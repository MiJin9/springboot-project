package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.MarketThumbVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class MarketThumbDAOtest {

    @Autowired
    private MarketThumbDAO marketThumbDAO;

    @Test
    public void testInsert(){
        UUID uuid = UUID.randomUUID();
        MarketThumbVO t = new MarketThumbVO();
        t.setUuid(uuid+"");
        t.setUploadPath("3123");
        t.setItemnum(36868L);
        t.setFileName("asdasd");
        t.setImage(true);
        marketThumbDAO.insert(t);
    }


}
