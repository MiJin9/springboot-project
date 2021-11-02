package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReturnVO {
    private Long num;
    private String item;
    private String local;
    private int size;
    private int input;
    private int operate;
    private int income;
}
