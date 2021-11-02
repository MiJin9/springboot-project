package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.ReturnDAO;
import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.beans.vo.ReturnVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnServiceImple implements ReturnService{

    private final ReturnDAO returnDAO;

    @Override
    public List<ReturnVO> getList(ReturnCri returnCri) {
        return returnDAO.getList(returnCri);
    }

    @Override
    public List<ReturnVO> searchList(ReturnCri returnCri) {
        return returnDAO.searchList(returnCri);
    }

    @Override
    public int getTotal(ReturnCri returnCri) {
        return returnDAO.getTotal(returnCri);
    }
}
