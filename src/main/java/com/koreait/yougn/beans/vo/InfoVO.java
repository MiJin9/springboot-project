package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InfoVO {
    private int num;
    private String name;
    private String url;
}
