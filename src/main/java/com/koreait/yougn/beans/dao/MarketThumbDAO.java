package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.MarketThumbVO;
import com.koreait.yougn.mappers.MarketThumbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketThumbDAO {

    @Autowired
    private MarketThumbMapper marketThumbMapper;

    public void insert(MarketThumbVO marketThumbVO){marketThumbMapper.insert(marketThumbVO);}

    public void delete(String uuid){marketThumbMapper.delete(uuid);}

    public List<MarketThumbVO> findByNum(Long itemnum){return marketThumbMapper.findByNum(itemnum);}

    public void deleteAll(Long itemnum){marketThumbMapper.deleteAll(itemnum);}

    public List<MarketThumbVO> getOldFiles() {return marketThumbMapper.getOldFiles();}
}
