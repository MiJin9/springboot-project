package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/expo/*")
@RequiredArgsConstructor
public class ExpoController {

    @GetMapping("list")
    public String list(){
    return "/expo/list";

    }

    @GetMapping({"readDetail","modify"})
    public void readDetail(){
    }
}
