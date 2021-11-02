package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FaqVO {
    private Long num;
    private String title;
    private String content;
    private String id;
    private String regDate;
    private int status;
    private String reply;
}
