package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long ordernum;
    private Long itemnum;
    private String userid;
    private String orderpayment;
    private String orderdate;
    private String orderaddress;
    private String orderaddressdetail;
    private Long odercount;
}
