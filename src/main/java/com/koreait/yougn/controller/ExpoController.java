package com.koreait.yougn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    @GetMapping("writeExpo")
    public String writeExpo(){
        return "/expo/writeExpo";

    }

    @GetMapping("modifyExpo")
    public String modifyExpo(){
        return "/expo/modifyExpo";

    }

    @GetMapping({"readDetail","modify"})
    public void readDetail(){
    }
}
