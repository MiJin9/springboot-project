package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplyVO {
    private Long num;
    private Long ClassNum;
    private String id;
    private String merchant_uid;
}
