package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.services.ExpoService;
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

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/expo/*")
@RequiredArgsConstructor
public class ExpoController {
    private final ExpoService expoService;

    /*리스트*/
    @GetMapping("list")
    public String list(Criteria criteria, Model model){
        model.addAttribute("list", expoService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(expoService.getTotal(criteria), 10, criteria));
        return "/expo/list";

    }
//    /*글 작성*/
//    //페이지 이동
//    @GetMapping("writeExpo")
//    public void writeExpo(ExpoVO vo, Criteria criteria, Model model){
//    vo.setUserId("아이디123");
//        model.addAttribute("vo", vo);
//        model.addAttribute("criteria", criteria);
//    }
//    //메소드
//    @PostMapping("writeExpo")
//    public RedirectView writeExpo(ExpoVO expoVO, RedirectAttributes rttr){
//        expoVO.setUserId("아이디123");
//        expoService.register(expoVO);
//        rttr.addFlashAttribute("expoNum", expoVO.getExpoNum());
//        return new RedirectView("/expo/list");
//
//    }
//    //글 수정
//    //페이지이동
//    @GetMapping("modifyExpo")
//    public void modifyExpo(@RequestParam("expoNum") Long expoNum, Criteria criteria, Model model){
//        model.addAttribute("vo", expoService.get(expoNum));
//        model.addAttribute("cri", criteria);
//    }
//
//    //메소드
//    @PostMapping("modifyExpo")
//    public RedirectView modifyExpo(Criteria criteria, ExpoVO expoVO, RedirectAttributes rttr){
//        log.info("------------------------------------");
//        log.info("modifyExpo--------------------------------------------------");
//        log.info("------------------------------------");
//
//        if(expoService.modify(expoVO)){
//           rttr.addAttribute("result", "success") ;
//           rttr.addAttribute("expoNum", expoVO.getExpoNum());
//        }
//        return new RedirectView("readDetail" + criteria.getListLink());
//    }
//
//
//    //상세보기
//    @GetMapping({"readDetail","modify"})
//    public void readDetail(@RequestParam("expoNum") Long expoNum, Criteria criteria, Model model){
//        model.addAttribute("expoNum", expoService.get(expoNum));
//        model.addAttribute("criteria", criteria);
//    }
//
//    //삭제
//    @PostMapping("remove")
//    public RedirectView remove(@RequestParam("expoNum") Long expoNum, RedirectAttributes rttr){
//        log.info("-------------------------------");
//        log.info("remove + " + expoNum);
//        log.info("-------------------------------");
//        if(expoService.remove(expoNum)) {
//            rttr.addFlashAttribute("result", "success");
//        }else{
//            rttr.addFlashAttribute("result", "fail");
//        }
//        return new RedirectView("/expo/list");
//        }
    }
