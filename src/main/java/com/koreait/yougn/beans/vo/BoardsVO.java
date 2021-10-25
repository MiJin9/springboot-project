package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardsVO {
    private Long bno;
    private String title;
    private String content;
    private String id;
    private String regDate;
    private String updateDate;
    private Long viewCnt;
    private int type;
}
