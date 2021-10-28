package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyVO {
    private Long rno;
    private Long bno;
    private String content;
    private String id;
    private String regDate;
    private String updateDate;
}
