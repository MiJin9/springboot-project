package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria {
    private int pageNum;
    private int amount;
    private int boardType;
    private String keyType;
    private String keyword;
    private String userId;
    private String buyerId;

    public Criteria(){
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("keyType", keyType)
                .queryParam("keyword", keyword);
        return builder.toUriString();
    }

    public String[] getTypeArr(){
        return keyType == null ? new String[] {} : keyType.split("");
    }
}