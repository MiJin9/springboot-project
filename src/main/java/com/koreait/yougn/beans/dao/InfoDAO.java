package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.InfoVO;
import com.koreait.yougn.mappers.InfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InfoDAO {
    private final InfoMapper infoMapper;

    public List<InfoVO> getInfoList(Criteria criteria){return infoMapper.getInfoList(criteria);}
    public int getTotal(){return infoMapper.getTotal();}
}
