package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.MarketThumbVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketThumbMapper {

    public void insert(MarketThumbVO marketThumbVO);
    public void delete(String uuid);
    public List<MarketThumbVO> findByNum(Long itemnum);
    public void deleteAll(Long itemnum);
    public List<MarketThumbVO> getOldFiles();

}
