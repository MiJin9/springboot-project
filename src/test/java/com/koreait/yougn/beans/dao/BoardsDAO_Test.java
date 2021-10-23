package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardsDAO_Test {

    @Autowired
    private BoardsDAO boardsDAO;

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        criteria.setType("1");
        boardsDAO.getList(criteria).forEach(board -> log.info(board.toString()));
    }
}
