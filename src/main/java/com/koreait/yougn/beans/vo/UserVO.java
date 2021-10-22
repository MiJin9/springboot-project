package com.koreait.yougn.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long num;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String addressDetail;
    private int status;
}
