package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.HallCri;
import com.koreait.yougn.beans.vo.HallVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HallMapper {
    public List<HallVO> getList(HallCri hallCri);
    public int getTotal(HallCri hallCri);
}
