package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.*;
import com.koreait.yougn.services.ClassService;
import com.koreait.yougn.services.HallService;
import com.koreait.yougn.services.ReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/support/*")
@RequiredArgsConstructor
public class Supportcontroller {

    private final ReturnService returnService;
    private final HallService hallService;
    private final ClassService classService;

    @GetMapping("hallList")
    public String hallList(HallCri hallCri, Model model){
        if(hallCri.getKeyword() != null){
            String temp =hallCri.getKeyword();
            hallCri.setKeyword(temp.replace(" ","").length() == 0? null :hallCri.getKeyword());
        }
        if(hallCri.getSido() != null){
            hallCri.setSido(hallCri.getSido().equals("시/도 선택")?null:hallCri.getSido());
        }
        if(hallCri.getSido() != null){
            hallCri.setSido(hallCri.getSido().equals("")?null:hallCri.getSido());
        }
        if(hallCri.getGugun() != null) {
            hallCri.setGugun(hallCri.getGugun().equals("전체")?null:hallCri.getGugun());
        }
        if(hallCri.getGugun() != null){
            hallCri.setGugun(hallCri.getGugun().equals("")?null:hallCri.getGugun());
        }
        model.addAttribute("list",hallService.getList(hallCri));
        model.addAttribute("pageMaker",new PageDTO(hallService.getTotal(hallCri),10,hallCri));
        return "support/hallList";
    }

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
    public String classList(ClassCri classCri, Model model){
        if(classCri.getKeyword() != null){
            String temp = classCri.getKeyword();
            classCri.setKeyword(temp.replace(" ","").length() == 0? null : classCri.getKeyword());
        }
        List<ClassVO> list = classService.getList(classCri);
        ArrayList<Boolean> checkList = new ArrayList<>();
        String today = getToday();
        for (ClassVO vo : list) {
            checkList.add(vo.getRecruitCloseDate().compareTo(today) != -1);
        }

        model.addAttribute("list", list);
        model.addAttribute("checkList",checkList);
        model.addAttribute("pageMaker",new PageDTO(classService.getTotal(classCri),10,classCri));
        return "support/classList";
    }

    private String getToday(){
        Calendar c =Calendar.getInstance();
        String today = "" + c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
        return today;
    }

    @GetMapping("classView")
    public void classView(Long num, Model model){
        ClassVO classVO = classService.getClass(num);
        model.addAttribute("check" , classVO.getRecruitDate().compareTo(getToday()) <= 0);
        model.addAttribute("class",classVO);
    }

    @GetMapping("infoList")
    public String infoList(){return "support/infoList";}

    @GetMapping("home")
    public String home(){ return "home";}
}
