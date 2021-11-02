package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.InfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InfoMapper {
    public List<InfoVO> getInfoList(Criteria criteria);
    public int getTotal();
}
