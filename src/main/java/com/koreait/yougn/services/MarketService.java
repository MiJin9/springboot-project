package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.*;
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

    // 주문
    public void orderRegister(OrderVO orderVO);

    public List<OrderVO> orderGetList(Criteria criteria);

    public int orderGetTotal(Criteria criteria);

    public List<OrderVO> orderMyList(Criteria criteria);


    public boolean status(Long orderNum);
}
