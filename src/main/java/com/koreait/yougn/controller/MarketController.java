package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.PageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/market/*")
@RequiredArgsConstructor
public class MarketController {

    /*리스트*/
    @GetMapping("marketList")
    public String marketList(Criteria criteria, Model model) {
/*        model.addAttribute("list", .getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(expoService.getTotal(criteria), 10, criteria));*/
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
    @GetMapping("marketKart")
    public String marketKart() {
        return "/market/marketKart";
    }
    @GetMapping("marketMyorder")
    public String marketMyorder() { return "/market/marketMyorder"; }
    @GetMapping("marketOrderList")
    public String marketOrderList() {
        return "/market/marketOrderList";
    }
}
