package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.beans.vo.ReturnVO;
import com.koreait.yougn.mappers.ReturnMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReturnDAO {
    private final ReturnMapper returnMapper;

    public List<ReturnVO> getList(ReturnCri returnCri){
        return  returnMapper.selectAll(returnCri);
    }
    public List<ReturnVO> searchList(ReturnCri returnCri){
        return returnMapper.selectList(returnCri);
    }
    public int getTotal(ReturnCri returnCri){return returnMapper.getTotal(returnCri);}
}
