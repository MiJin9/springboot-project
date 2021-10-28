package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.beans.vo.ReturnCri;
import com.koreait.yougn.services.ReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/support/*")
@RequiredArgsConstructor
public class Supportcontroller {

    private final ReturnService returnService;

    @GetMapping("hallList")
    public String hallList(){return "support/hallList";}

    @GetMapping(value = "returnList")
    public String returnList(ReturnCri returnCri, Model model){
        if(returnCri.getKeyword() != null){
            String temp =returnCri.getKeyword();
            returnCri.setKeyword(temp.replace(" ","").length() == 0? null :returnCri.getKeyword());
        }
        if(returnCri.getLocal() != null){
            returnCri.setLocal(returnCri.getLocal().equals("시/도 선택")?null:returnCri.getLocal());
        }
        if(returnCri.getItem() != null){
            returnCri.setItem(returnCri.getItem().equals("전체")?null:returnCri.getItem());
        }
        model.addAttribute("list",returnService.searchList(returnCri));
        model.addAttribute("pageMaker",new PageDTO(returnService.getTotal(returnCri),10,returnCri));
        return "support/returnList";
    }

    @GetMapping("classList")
    public String classList(){return "support/classList";}

    @GetMapping("infoList")
    public String infoList(){return "support/infoList";}

    @GetMapping("classView")
    public void classView(){}

    @GetMapping("home")
    public String home(){ return "home";}
}
