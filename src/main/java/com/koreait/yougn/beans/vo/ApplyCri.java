package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class ApplyCri extends Criteria{
    private int pageNum;
    private int amount;
    private String id;

    public ApplyCri(){
        this(1, 10);
    }

    public ApplyCri(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    @Override
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("id", id);
        return builder.toUriString();
    }

}
