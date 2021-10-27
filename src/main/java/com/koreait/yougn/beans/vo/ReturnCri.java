package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class ReturnCri {
    private int pageNum;
    private int amount;
    private String keyword;
    private String local;
    private String item;

    public ReturnCri(){
        this(1, 10);
    }

    public ReturnCri(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("local", local)
                .queryParam("item",item)
                .queryParam("keyword", keyword);
        return builder.toUriString();
    }

}
