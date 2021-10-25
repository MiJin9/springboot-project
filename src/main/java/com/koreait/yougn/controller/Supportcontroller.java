package com.koreait.yougn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/support/*")
@RequiredArgsConstructor
public class Supportcontroller {

    @GetMapping("hallList")
    public String hallList(){return "support/hallList";}

    @GetMapping("returnList")
    public String returnList(){return "support/returnList";}

    @GetMapping("classList")
    public String classList(){return "support/classList";}

    @GetMapping("infoList")
    public String infoList(){return "support/infoList";}

    @GetMapping("classView")
    public void classView(){}

    @GetMapping("home")
    public String home(){ return "home";}
}
