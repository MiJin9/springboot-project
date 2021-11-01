package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long orderNum;
    private Long itemNum;
    private String itemName;
    private String buyerId;
    private String userId;
    private String orderPayment;
    private String orderDate;
    private String orderAddress;
    private String orderAddressDetail;
    private String orderReceiver;
    private String orderPhoneNum;
    private String orderMemo;
    private Long orderCount;
    private int status;
}
