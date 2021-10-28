package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.MarketDAO;
import com.koreait.yougn.beans.dao.ThumbDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.ItemVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketServiceImple implements MarketService {
    private final MarketDAO marketDAO;
    private final ThumbDAO thumbDAO;

    @Override
    public void register(ItemVO itemVO) {
        marketDAO.register(itemVO);
    }

    @Override
    public ItemVO get(Long itemnum) {
        return marketDAO.get(itemnum);
    }

    @Override
    public boolean modify(ItemVO itemVO) {
        return marketDAO.modify(itemVO);
    }

    @Override
    public boolean remove(Long itemnum) {
        return marketDAO.remove(itemnum);
    }

    @Override
    public List<ItemVO> getList(Criteria criteria) {
        List<ItemVO> itemVOList = marketDAO.getList(criteria);
        //빠른 for문
        for (ItemVO itemVO : itemVOList){
            //반복돌려서 sysdate에서 시간만 잘려서 나오게
            itemVO.setItemregDate(itemVO.getItemregDate().split("")[0]);
            itemVO.setItemupdateDate(itemVO.getItemupdateDate().split("")[0]);
        }
        return itemVOList;
    }

    @Override
    public int getTotal(Criteria criteria) {
        return marketDAO.getTotal(criteria);
    }

    @Override
    public List<ThumbVO> getAttachList(Long itemnum) {
        return thumbDAO.findByNum(itemnum);
    }
}
