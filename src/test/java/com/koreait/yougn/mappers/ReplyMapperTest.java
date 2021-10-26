package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ReplyVO;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Data
public class ReplyMapperTest {

    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void testInsert(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setBno(300L);
        replyVO.setContent("댓글");
        replyVO.setId("댓글");
        replyMapper.insert(replyVO);
    }

}
