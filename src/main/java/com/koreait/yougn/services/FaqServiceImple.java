package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.FaqDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqServiceImple implements FaqService{

    private final FaqDAO faq;

    @Override
    public void register(FaqVO faqVO){
        faq.register(faqVO);
    }

    @Override
    public FaqVO get(Long num) {
        return faq.get(num);
    }

    @Override
    public boolean remove(Long num) {
        return faq.remove(num);
    }

    @Override
    public List<FaqVO> getList(Criteria criteria) {
//        날짜에서 시간제거
         List<FaqVO> list = faq.getList(criteria);
        for (FaqVO vo:list) {
            vo.setRegDate(vo.getRegDate().split(" ")[0]);
        }
        return list;
    }

    @Override
    public int getTotal(Criteria criteria) {
        return faq.getTotal(criteria);
    }

    @Override
    public List<FaqVO> getListId(Criteria criteria, String id) {
        List<FaqVO> list = faq.getListId(criteria, id);
        for (FaqVO vo:list) {
            vo.setRegDate(vo.getRegDate().split(" ")[0]);
        }
        return list;
    }

    @Override
    public int getTotalId(Criteria criteria, String id) {
        return faq.getTotalId(criteria, id);
    }
}
