package com.koreait.yougn.beans.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExpoVO {

    private Long expoNum;
    private String expoTitle;
    private String expoContent;
    private String userId;
    private String expoRegDate;
    private String expoUpdateDate;
}
