package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.BoardsVO;
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
        criteria.setKeyType("1");
        boardsDAO.getList(criteria).forEach(board -> log.info(board.toString()));
    }

    @Test
    public void testinsertSelectKey_bno(){
        BoardsVO vo = new BoardsVO();
        vo.setTitle("팝니다 다오 테스트 ");
        vo.setContent("다오 테스트");
        vo.setId("다오 테스트");
        vo.setBno(1L);
        boardsDAO.register(vo);
    }
}
