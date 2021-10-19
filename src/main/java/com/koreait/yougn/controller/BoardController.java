package com.koreait.yougn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {

    @GetMapping("list")
    public String notice(){
        return "/board/list";
    }

    @GetMapping("buyAndSale")
    public String buyAndSale(){
        return "/board/buyAndSale";
    }

    @GetMapping("view")
    public String view(){return "/board/view";}
    @GetMapping("write")
    public String write(){return "/board/write";}
}
