package com.koreait.yougn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/market/*")
@RequiredArgsConstructor
public class MarketController {

    @GetMapping("marketList")
    public String marketList() {
        return "/market/marketList";
    }
    @GetMapping("marketModify")
    public String marketModify() {
        return "/market/marketModify";
    }
    @GetMapping("marketWrite")
    public String marketWrite() {
        return "/market/marketWrite";
    }
    @GetMapping("marketView")
    public String marketView() {
        return "/market/marketView";
    }
}
