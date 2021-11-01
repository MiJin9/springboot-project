package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class HallCri extends Criteria{
    private int pageNum;
    private int amount;
    private String keyword;
    private String sido;
    private String gugun;

    public HallCri(){
        this(1, 10);
    }

    public HallCri(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    @Override
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("sido",sido)
                .queryParam("gugun",gugun)
                .queryParam("keyword", keyword);
        return builder.toUriString();
    }
}
