package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class ThumbDAOtest {

    @Autowired
    private ThumbDAO thumbDAO;

    @Test
    public void testInsert(){
        UUID uuid = UUID.randomUUID();
        ThumbVO t = new ThumbVO();
        t.setUuid(uuid+"");
        t.setUploadPath("3123");
        t.setExpoNum(3L);
        t.setFileName("asdasd");
        t.setImage(true);
        thumbDAO.insert(t);
    }


}
