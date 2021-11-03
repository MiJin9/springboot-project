package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplyVO {
    private Long num;
    private Long classNum;
    private String id;
    private String merchant_uid;
    private String imp_uid;
}
