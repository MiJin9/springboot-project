package com.koreait.yougn;

import com.koreait.yougn.beans.vo.MailSenderRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MailTest {

    @Autowired
    MailSenderRunner mailSender;

    @Test
    public void send() throws Exception{
        mailSender.send("kkk_3339@naver.com", "테스트1", "테스트2");
    }
}
