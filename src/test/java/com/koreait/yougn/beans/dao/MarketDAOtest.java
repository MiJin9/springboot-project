package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MarketDAOtest {

    @Autowired
    private MarketDAO marketDAO;

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        marketDAO.getList(criteria).forEach(marketDAO -> log.info(marketDAO.toString()));
    }

    @Test
   public void register(){
        ItemVO itemVO = new ItemVO();
        itemVO.setItemname("제목123");
        itemVO.setItemcontent("내용123");
        itemVO.setUserid("아이디123");
        itemVO.setItemprice("50000");
        itemVO.setItemdeliverprice("무료");
        itemVO.setItemtotalcount("50000");
        itemVO.setItemhome("미국산");
        marketDAO.register(itemVO);
    }

    @Test
    public void modify() {
        ItemVO itemVO = new ItemVO();
        itemVO.setItemnum(99L);
        itemVO.setItemname("제목123");
        itemVO.setItemcontent("내용123");
        itemVO.setUserid("아이디123");
        itemVO.setItemprice("50000");
        itemVO.setItemdeliverprice("무료");
        itemVO.setItemtotalcount("50000");
        itemVO.setItemhome("미국산");
        marketDAO.modify(itemVO);

    }

    @Test
    public void remove(){
        marketDAO.remove(99L);
    }

    @Test
    public void getTotal(){
        Criteria criteria = new Criteria();
        marketDAO.getTotal(criteria);
    }

}
