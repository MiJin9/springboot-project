package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class ClassCri extends Criteria{
    private int pageNum;
    private int amount;
    private String keyword;

    public ClassCri(){
        this(1, 10);
    }

    public ClassCri(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    @Override
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("keyword", keyword);
        return builder.toUriString();
    }

}
