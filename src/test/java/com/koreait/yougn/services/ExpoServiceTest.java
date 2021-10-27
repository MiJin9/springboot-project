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
        ExpoVO expoVO = new ExpoVO();
        expoVO.setExpoTitle("제목");
        expoVO.setExpoContent("내용");
        expoVO.setUserId("아이디");
        expoService.register(expoVO);
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
}
