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
public class MarketControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){ mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}

    @Test
    public void testList() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/market/marketList")
                .param("itemnum", "1")
                .param("pageNum", "1")
                .param("amount", "10")
                .param("type", "T")
                .param("keyword", "복숭아 팜")
               )
                .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void testDetail() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/market/marketView")
                        .param("itemnum", "1")
                        .param("pageNum", "1")
                        .param("amount", "10")
                        .param("type", "T")
                        .param("keyword", "복숭아 팜")
                )
                        .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void testRegister() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/market/marketWrite")
                        .param("userid", "1")
                        .param("itemcontent", "2")
                        .param("itemname", "3")
                        .param("itemprice", "4")
                        .param("itemhome", "5")
                        .param("itemdeliverprice", "6")
                        .param("itemtotalcount", "7")
                )
                        .andReturn().getModelAndView().getModelMap().toString());
    }


}
