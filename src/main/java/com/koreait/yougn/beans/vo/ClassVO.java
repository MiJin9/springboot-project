package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ClassVO {
    private Long num;
    private String name;
    private String title;
    private String content;
    private int price;
    private String place;
    private String address;
    private int headNum;
    private int headCount;
    private String openDate;
    private String closeDate;
    private String startTime;
    private String endTime;
    private String recruitDate; // 모집 기간
    private String recruitCloseDate; // 모집 기간
    private String regDate;
    private String updateDate;

    private List<ThumbVO> fileList;
}