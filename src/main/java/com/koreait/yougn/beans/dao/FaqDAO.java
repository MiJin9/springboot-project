package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.FaqVO;
import com.koreait.yougn.beans.vo.UserVO;
import com.koreait.yougn.mappers.FaqMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FaqDAO {

    private final FaqMapper mapper;

    public void register(FaqVO faq){mapper.insertSelectKey_num(faq);}

    public FaqVO get(Long num){
        return mapper.read(num);
    }

    public boolean remove(Long num){
        return mapper.delete(num) == 1;
    }

    public List<FaqVO> getList(Criteria criteria){return mapper.getList(criteria);}

    public int getTotal(Criteria criteria){return mapper.getTotal(criteria);}

    public List<FaqVO> getListId(Criteria criteria, String id){return mapper.getListId(criteria, id);}

    public int getTotalId(Criteria criteria, String id){return mapper.getTotalId(criteria, id);}

    public boolean insertReply(FaqVO faq){return mapper.insertReply(faq) == 1;}

    public FaqVO readReply(Long num){return mapper.readReply(num);}

}
