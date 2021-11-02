package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.HallCri;
import com.koreait.yougn.beans.vo.HallVO;
import com.koreait.yougn.mappers.HallMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HallDAO {

    private final HallMapper hallMapper;

    public List<HallVO> getList(HallCri hallCri){return hallMapper.getList(hallCri);}

    public int getTotal(HallCri hallCri){return hallMapper.getTotal(hallCri);}
}
