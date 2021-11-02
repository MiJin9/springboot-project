package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.beans.vo.ReturnVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReturnService {
    public List<ReturnVO> getList(ReturnCri returnCri);
    public List<ReturnVO> searchList(ReturnCri returnCri);
    public int getTotal(ReturnCri returnCri);
}
