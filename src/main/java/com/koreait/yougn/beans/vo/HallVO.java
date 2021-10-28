package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class HallVO {
    private int num;
    private String name;
    private String call;
    private String sido;
    private String gugun;
    private int type;
}
