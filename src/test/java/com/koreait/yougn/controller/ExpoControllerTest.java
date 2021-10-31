package com.koreait.yougn.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class ExpoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){ mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}

    @Test
    public void testList() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/expo/list")
                        .param("expoNum", "1")
                .param("pageNum", "1")
                .param("amount", "10")
                .param("type", "T")
                .param("keyword", "딸기 스마트팜에 놀러오세요~!")
               )
                .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void testDetail() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/expo/readDetail")
                        .param("expoNum", "1")
                        .param("pageNum", "1")
                        .param("amount", "10")
                        .param("type", "T")
                        .param("keyword", "딸기 스마트팜에 놀러오세요~!")
                )
                        .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void testRegister() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/expo/writeExpo")
//                        expovo.setUserId("1");
//                        expovo.setExpoContent("2");
//                        expovo.setExpoTitle("3");
//                        expovo.setFarmName("5");
//                        expovo.setFarmerName("6");
//                        expovo.setFarmAddress("7");
//                        expovo.setFarmPhone("8");
//                        expovo.setFarmProduct("9");
                        .param("userId", "1")
                        .param("expoContent", "2")
                        .param("expoTitle", "3")
                        .param("farmName", "4")
                        .param("farmerName", "5")
                        .param("farmAddress", "6")
                        .param("farmPhone", "7")
                        .param("farmProduct", "8")
                )
                        .andReturn().getModelAndView().getModelMap().toString());
    }


}
