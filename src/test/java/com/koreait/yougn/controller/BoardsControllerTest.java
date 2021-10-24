package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
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
public class BoardsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/buyAndSell")
                        .param("boardType", "1")
                        .param("pageNum", "1")
                        .param("amount", "10")
                        .param("type", "T")
                        .param("keyword", "테스트")
                )
                        .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void testRegister() throws Exception {
        String bno = mockMvc.perform(
                MockMvcRequestBuilders.post("/board/write")
                        .param("title", "팝니다 등록 컨트롤러 테스트")
                        .param("content", "팝니다 등록 컨트롤러 테스트")
                        .param("id", "장태순")
                        .param("type", "1")
        ).andReturn().getFlashMap().toString();

        log.info(bno);
    }
}
