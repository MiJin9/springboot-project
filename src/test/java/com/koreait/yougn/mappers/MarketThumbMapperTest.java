package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.MarketThumbVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class MarketThumbMapperTest {

    @Autowired
    private MarketThumbMapper marketThumbMapper;
    @Test
    public void testInsert(){
        MarketThumbVO t = new MarketThumbVO();
        UUID uuid = UUID.randomUUID();
        t.setUuid(uuid + "");
        t.setUploadPath("3123");
        t.setItemnum(36868L);
        t.setFileName("asdasd");
        t.setImage(true);
        marketThumbMapper.insert(t);
    }
}
