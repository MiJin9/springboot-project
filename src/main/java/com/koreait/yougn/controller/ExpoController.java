package com.koreait.yougn.controller;

import com.koreait.yougn.services.Criteria;
import com.koreait.yougn.services.ExpoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/expo/*")
@RequiredArgsConstructor
public class ExpoController {

    @GetMapping("list")
    public String list(){
    return "/expo/list";

    }

    @GetMapping({""})
}
