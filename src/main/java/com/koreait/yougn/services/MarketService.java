package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ItemVO;
import com.koreait.yougn.beans.vo.MarketThumbVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarketService {

    public void register (ItemVO itemVO);

    public ItemVO get(Long itemnum);

    public boolean modify(ItemVO itemVO);

    public boolean remove(Long itemnum);

    public List<ItemVO> getList(Criteria criteria);

    public int getTotal(Criteria criteria);

    public List<MarketThumbVO> getAttachList(Long itemnum);
}
