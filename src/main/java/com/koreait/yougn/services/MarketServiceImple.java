package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.MarketDAO;
import com.koreait.yougn.beans.dao.MarketThumbDAO;
import com.koreait.yougn.beans.dao.ThumbDAO;
import com.koreait.yougn.beans.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MarketServiceImple implements MarketService {
    private final MarketDAO marketDAO;
    private final MarketThumbDAO marketThumbDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(ItemVO itemVO) {
        marketDAO.register(itemVO);/* 글 작성*/ /*여기서 가지고 오는거 아니야?*/
        log.info("----------------------------글작성------------------------------");
        if(itemVO.getAttachList() == null || itemVO.getAttachList().size() == 0){
            log.info("----------------------------파일 없음------------------------------");
            return; /* 파일이 없으면 */
        }
        log.info("----------------------------파일 있음------------------------------");
        log.info(itemVO.getItemnum() + "");  /*어째서?*/
        /* 파일이 있으면*/
        log.info("----------------------------파일 내용------------------------------");
        itemVO.getAttachList().forEach(thumb -> {

            thumb.setItemnum(itemVO.getItemnum());
            log.info(thumb.getUuid() + " : uu아이디");
            log.info(thumb.getItemnum()+": 번호");
            log.info(thumb.getFileName() + ": 파일 이름");
            log.info(thumb.getUploadPath() + " : 파일 경로");
            marketThumbDAO.insert(thumb);
        });
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
    public List<MarketThumbVO> getAttachList(Long itemnum) {
        return marketThumbDAO.findByNum(itemnum);
    }


    /*오더*/
    @Override
    public void orderRegister(OrderVO orderVO) {
        marketDAO.orderRegister(orderVO);
    }

    @Override
    public List<OrderVO> orderGetList(Criteria criteria) {
        List<OrderVO> orderList = marketDAO.orderGetList(criteria);
        //빠른 for문
        for (OrderVO orderVO : orderList){
            //반복돌려서 sysdate에서 시간만 잘려서 나오게
            orderVO.setOrderDate(orderVO.getOrderDate().split("")[0]);
        }
        return orderList;
    }

    @Override
    public int orderGetTotal(Criteria criteria) {
        return marketDAO.orderGetTotal(criteria);
    }
}
