package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ItemVO {
    private Long itemnum;
    private String itemname;
    private String itemcontent;
    private String userid;
    private String itemdeliverprice;
    private String itemhome;
    private String itemprice;
    private String itemtotalcount;
    private String itemregDate;
    private String itemupdateDate;
    private List<MarketThumbVO> attachList;
}
