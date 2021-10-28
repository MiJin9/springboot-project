package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardsServiceTest {

    @Autowired
    private BoardsService boardsService;

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        criteria.setKeyType("2");
        boardsService.getList(criteria).forEach(board -> log.info(board.toString()));
    }
    @Test
    public void testGet(){
        boardsService.get(3L);
    }

}
