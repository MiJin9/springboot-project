package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MarketThumbVO {
    private String uuid;
    private String uploadPath;
    private Long itemnum;
    private String fileName;
    private boolean image;
}
