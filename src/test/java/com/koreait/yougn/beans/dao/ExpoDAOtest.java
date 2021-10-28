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
        ExpoVO expovo =  new ExpoVO();
        expovo.setUserId("1");
        expovo.setExpoContent("2");
        expovo.setExpoTitle("3");
        expovo.setFarmName("5");
        expovo.setFarmerName("6");
        expovo.setFarmAddress("7");
        expovo.setFarmPhone("8");
        expovo.setFarmProduct("9");
        expoDAO.register(expovo);
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
