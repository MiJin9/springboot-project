package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.ReplyDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ReplyPageDTO;
import com.koreait.yougn.beans.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDAO replyDAO;

    public int register(ReplyVO replyVO){
        log.info("register..............");
        return replyDAO.register(replyVO);
    }

    public ReplyVO get(Long rno){
        log.info("get..............");
        return replyDAO.get(rno);
    }

    public int remove(Long rno){
        log.info("remove..............");
        return replyDAO.remove(rno);
    }

    public int modify(ReplyVO replyVO){
        log.info("modify..............");
        return replyDAO.modify(replyVO);
    }

    public ReplyPageDTO getList(Long bno, Criteria criteria){
        log.info("getList..............");
        return new ReplyPageDTO(replyDAO.getTotal(bno), replyDAO.getList(bno, criteria));
    }
}
