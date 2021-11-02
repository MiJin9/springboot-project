package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.beans.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ReturnMapperTest {

    @Autowired
    private ReturnMapper returnMapper;

    @Test
    public void selectAllTest(){
        ReturnCri returnCri = new ReturnCri();
        List<ReturnVO> list = returnMapper.selectAll(returnCri);

        list.forEach(vo -> log.info(vo.toString()));
    }

    @Test
    public void selectListTest(){
        ReturnCri returnCri = new ReturnCri();
//        returnCri.setLocal("강원");
//        returnCri.setItem("곰취");
        List<ReturnVO> list = returnMapper.selectList(returnCri);
        list.forEach(vo -> log.info(vo.toString()));
    }

    @Test
    public void getTotalTest(){
        ReturnCri returnCri = new ReturnCri();
        returnCri.setLocal("강원");
        returnCri.setKeyword("한우");
        PageDTO pageDTO = new PageDTO(returnMapper.getTotal(returnCri),10,returnCri);
        log.info("PageDTO Test : "+pageDTO.getTotal());
        log.info("getListLink : "+pageDTO.getCriteria().getListLink());
    }
}
