package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ExpoVO {

    private Long expoNum;
    private String expoTitle;
    private String expoContent;
    private String userId;
    private String expoRegDate;
    private String expoUpdateDate;
    private String farmName;
    private String farmerName;
    private String farmAddress;
    private String farmPhone;
    private String farmProduct;
    //input 태그의 name에
    //attachList[i].fileName...
    //방식으로 submit하면 자동으로 List에 add할 수 있게 된다.
    private List<ThumbVO> attachList;
}
