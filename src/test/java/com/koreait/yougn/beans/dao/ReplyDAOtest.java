package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyDAOtest {

    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void insert(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setBno(300L);
        replyVO.setId("테스트");
        replyVO.setContent("댓글 테스트");
        replyDAO.register(replyVO);

    }
}
