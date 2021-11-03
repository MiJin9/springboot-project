package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.services.ExpoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final ExpoService expoService;


    @GetMapping("/")
    public String list(Criteria criteria, Model model, HttpServletRequest r) {
        //List<ExpoVO> list = expoService.getList(criteria);
        String id = (String) r.getSession().getAttribute("sessionId");
        model.addAttribute("id", id);
        model.addAttribute("list", expoService.getList(criteria));

    return "index";
    }


}



