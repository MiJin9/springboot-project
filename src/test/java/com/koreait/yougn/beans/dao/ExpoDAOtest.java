package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ExpoDAOtest {

    @Autowired
    private ExpoDAO expoDAO;

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        expoDAO.getList(criteria).forEach(expoDAO -> log.info(expoDAO.toString()));
    }
}
