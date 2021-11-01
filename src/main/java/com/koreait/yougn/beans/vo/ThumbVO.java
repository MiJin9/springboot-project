package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ThumbVO {
    private String uuid;
    private String uploadPath;
    private Long expoNum;
    private String fileName;
    private int fileType;
    private boolean image;
}
