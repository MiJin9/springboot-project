package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ExpoServiceTest {

    @Autowired
    private ExpoService expoService;

    @Test
    public void getList(){
        Criteria criteria = new Criteria();
        criteria.setPageNum(2);
        criteria.setAmount(10);
        expoService.getList(criteria);

    }

    @Test
    public void register(){
        ExpoVO expovo =  new ExpoVO();
        expovo.setUserId("1");
        expovo.setExpoContent("2");
        expovo.setExpoTitle("3");
        expovo.setFarmName("5");
        expovo.setFarmerName("6");
        expovo.setFarmAddress("7");
        expovo.setFarmPhone("8");
        expovo.setFarmProduct("9");
        expoService.register(expovo);
    }

    @Test
    public void modify() {
        ExpoVO expoVO = new ExpoVO();
        expoVO.setExpoNum(5L);
        expoVO.setExpoTitle("제목123");
        expoVO.setExpoContent("내용123");
        expoVO.setUserId("아이디123");
        expoService.modify(expoVO);

    }

    @Test
    public void remove(){
        expoService.remove(26L);
    }

    @Test
    public void getTotal(){
        Criteria criteria = new Criteria();
        expoService.getTotal(criteria);
    }

    @Test
    public void get(){expoService.get(68L); }
}
