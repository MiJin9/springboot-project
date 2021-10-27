package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.beans.vo.ReturnVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturnMapper {
    public List<ReturnVO> selectAll(ReturnCri returnCri);
    public List<ReturnVO> selectList(ReturnCri returnCri);
}
