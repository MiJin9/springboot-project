package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.MarketThumbDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.ItemVO;
import com.koreait.yougn.beans.vo.MarketThumbVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class MarketServiceTest {

    @Autowired
    private MarketService marketService;

    @Test
    public void getList(){
        Criteria criteria = new Criteria();
        criteria.setPageNum(2);
        criteria.setAmount(10);
        marketService.getList(criteria);

    }

    @Test
    public void register(){
        ItemVO itemVO = new ItemVO();
        itemVO.setUserid("1");
        itemVO.setItemcontent("2");
        itemVO.setItemname("3");
        itemVO.setItemhome("5");
        itemVO.setItemtotalcount("6");
        itemVO.setItemdeliverprice("7");
        itemVO.setItemprice("8");
        marketService.register(itemVO);
    }

    @Test
    public void modify() {
        ItemVO itemVO = new ItemVO();
        itemVO.setItemnum(75L);
        itemVO.setItemname("제목123");
        itemVO.setItemcontent("내용123");
        itemVO.setUserid("아이디123");
        itemVO.setItemprice("3000");
        itemVO.setItemtotalcount("300");
        itemVO.setItemhome("국산이");
        itemVO.setItemdeliverprice("500");
        marketService.modify(itemVO);

    }

    @Test
    public void remove(){
        marketService.remove(104L);
    }

    @Test
    public void getTotal(){
        Criteria criteria = new Criteria();
        marketService.getTotal(criteria);
    }

    @Test
    public void get(){marketService.get(74L); }
}
