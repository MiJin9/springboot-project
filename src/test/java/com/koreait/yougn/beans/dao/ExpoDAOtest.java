package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ExpoDAOtest {

    @Autowired
    private ExpoDAO expoDAO;

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        expoDAO.getList(criteria).forEach(expoDAO -> log.info(expoDAO.toString()));
    }

    @Test
   public void register(){
        ExpoVO expoVO = new ExpoVO();
        expoVO.setExpoTitle("제목");
        expoVO.setExpoContent("내용");
        expoVO.setUserId("아이디");
        expoDAO.register(expoVO);
    }

    @Test
    public void modify() {
        ExpoVO expoVO = new ExpoVO();
        expoVO.setExpoNum(3L);
        expoVO.setExpoTitle("제목123");
        expoVO.setExpoContent("내용123");
        expoVO.setUserId("아이디123");
        expoDAO.modify(expoVO);

    }

    @Test
    public void remove(){
        expoDAO.remove(4L);
    }

    @Test
    public void getTotal(){
        Criteria criteria = new Criteria();
        expoDAO.getTotal(criteria);
    }


}
