package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.BooleanString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ExpoMapperTest {

    @Autowired
    private ExpoMapper expoMapper;

    @Test
    public void testGetExpoList(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(10);
        expoMapper.getList(cri).forEach(expoMapper -> log.info(expoMapper.toString()));
    }

    @Test
    public void testRegister(){
        //#{userId}, #{expoContent}, #{expoTitle}, #{farmName}, #{farmerName}, #{farmAddress}, #{farmPhone}, #{farmProduct}
        ExpoVO expovo =  new ExpoVO();
        expovo.setUserId("1");
        expovo.setExpoContent("2");
        expovo.setExpoTitle("3");
        expovo.setFarmName("5");
        expovo.setFarmerName("6");
        expovo.setFarmAddress("7");
        expovo.setFarmPhone("8");
        expovo.setFarmProduct("9");
        expoMapper.insertSelectKey_expoNum(expovo);
    }



}
