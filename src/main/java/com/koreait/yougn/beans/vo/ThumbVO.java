package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ThumbVO {
//    uuid VARCHAR2(1000) NOT NULL,
//    uploadPath VARCHAR2(2000) NOT NULL,
//    thumbNum NUMBER(10),
//    thumbType NUMBER(10),
//    thumbName VARCHAR2(1000) NOT NULL,
//    image CHAR(1) /*이미지이면 1, 아니면 0*/

    private String uuid;
    private String uploadPath;
    private Long thumbNum;
    private int thumbType;
    private String thumbName;
    private boolean image;

}
