package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.*;
import com.koreait.yougn.services.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/market/*")
@RequiredArgsConstructor
public class MarketController {
    private final MarketService marketService;

    /*리스트*/
    @GetMapping("marketList")
    public String marketList(Criteria criteria, Model model) {
        model.addAttribute("list", marketService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(marketService.getTotal(criteria), 10, criteria));
        return "/market/marketList";
    }

    /*글 수정*/
    //페이지 이동
    @GetMapping("marketModify")
    public void marketModify(@RequestParam("itemnum") Long itemnum, Criteria criteria, Model model) {
        model.addAttribute("vo",marketService.get(itemnum));
        model.addAttribute("criteria",criteria);
    }

    //메소드
    @PostMapping("marketModify")
    public RedirectView marketModify(Criteria criteria, ItemVO itemVO, RedirectAttributes rttr) {
        log.info("------------------------------------");
        log.info("------------------marketModify--------------------------------------------------");
        log.info("------------------------------------");

        if (marketService.modify(itemVO)) {
            rttr.addAttribute("result", "success");
            rttr.addAttribute("itemnum", itemVO.getItemnum());
        }
        return new RedirectView("marketView" + criteria.getListLink());
    }

    /*글 작성*/
    //페이지 이동
    @GetMapping("marketWrite")
    public void marketWrite(ItemVO itemVO, Criteria criteria, Model model) {
        itemVO.setUserid("아이디1234");
        model.addAttribute("vo",itemVO);
        model.addAttribute("criteria",criteria);
    }

    //메소드
    @PostMapping("marketWrite")
    public RedirectView marketWrite(ItemVO itemVO, RedirectAttributes rttr) {
        itemVO.setUserid("아이디123");
        marketService.register(itemVO);
        rttr.addFlashAttribute("itemnum", itemVO.getItemnum());
        return new RedirectView("/market/marketList");

    }


    /*상세보기*/
    @GetMapping({"marketView"})
    public void marketView(@RequestParam("itemnum") Long itemnum, Criteria criteria, Model model) {
        model.addAttribute("item", marketService.get(itemnum));
        model.addAttribute("criteria",criteria);
    }


    /*삭제*/
    @GetMapping("remove")
    public RedirectView remove(@RequestParam("itemnum") Long itemnum, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove + " + itemnum);
        log.info("-------------------------------");

        if (marketService.remove(itemnum)) {
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("/market/marketList");
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
    @GetMapping("marketPayment")
    public String marketPayment() {
        return "/market/marketPayment";
    }
}
