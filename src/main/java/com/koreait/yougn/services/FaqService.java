package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.FaqVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaqService {
    public void register(FaqVO faq);
    public FaqVO get(Long num);
    public boolean remove(Long num);
    public List<FaqVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
    public List<FaqVO> getListId(Criteria criteria, String id);
    public int getTotalId(Criteria criteria, String id);
}
