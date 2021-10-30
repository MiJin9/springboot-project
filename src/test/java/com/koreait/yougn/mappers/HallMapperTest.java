package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.HallCri;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class HallMapperTest {

    @Autowired
    private HallMapper hallMapper;

    @Test
    public void getListTest(){
        HallCri hallCri = new HallCri();
        hallCri.setSido("강원");
        hallCri.setKeyword("주민");
        hallMapper.getList(hallCri).forEach( vo -> log.info(vo.toString()));
    }

    @Test
    public void getTotalTest(){
        HallCri hallCri = new HallCri();
        hallCri.setSido("강원");
        log.info(hallMapper.getTotal(hallCri)+"");
    }
}
