package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.BoardsVO;
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
    public void testGetList(){
        Criteria criteria = new Criteria();
        expoService.getList(criteria).forEach(expoService -> log.info(expoService.toString()));
    }
    @Test
    public void testGet(){
        expoService.get(3L);
    }
}
