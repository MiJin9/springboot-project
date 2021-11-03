package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.services.BoardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardsService boardsService;

    /*리스트*/
    @GetMapping("list")
    public String list(@RequestParam("boardType") int boardType, Criteria criteria, Model model, HttpServletRequest request){
        criteria.setBoardType(boardType);
        String id = (String)request.getSession().getAttribute("sessionId");
        model.addAttribute("id",id);
        model.addAttribute("list", boardsService.getList(criteria));    // 목록
        model.addAttribute("pageMaker", new PageDTO(boardsService.getTotal(criteria), 10, criteria));   //페이징
        return "board/list";
    }

    /*상세보기*/
    @GetMapping("read")
    public void read(@RequestParam("bno") Long bno,  Criteria criteria, Model model, HttpServletRequest request){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        String id = (String)request.getSession().getAttribute("sessionId");
        criteria.setUserId(id);
        model.addAttribute("board", boardsService.get(bno));
        model.addAttribute("criteria", criteria);
    }

    /* 글 작성 */
    //페이지 이동
    @GetMapping("write")
    public void write(BoardsVO vo,Criteria criteria, Model model, HttpServletRequest request){
        String id = (String)request.getSession().getAttribute("sessionId");
        vo.setId(id);
        model.addAttribute("vo", vo);
        model.addAttribute("criteria", criteria);
    }
    //메소드
    @PostMapping("write")
    public RedirectView write(BoardsVO boardsVO, RedirectAttributes rttr, HttpServletRequest request){
        String id = (String)request.getSession().getAttribute("sessionId");
        boardsVO.setId(id);
        boardsService.register(boardsVO);
        rttr.addFlashAttribute("bno",boardsVO.getBno());
        return new RedirectView("list?boardType=" + boardsVO.getType());
    }

    //글 수정
    @GetMapping("modify")
    public void modify(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request){
        String id = (String)request.getSession().getAttribute("sessionId");
        criteria.setUserId(id);
        model.addAttribute("vo", boardsService.get(bno));
        model.addAttribute("cri", criteria);
    }

    @PostMapping("modify")
    public RedirectView modify(Criteria criteria, BoardsVO boardsVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("modify-------------------------------------------------------------------------- : " + boardsVO.toString());
        log.info("-------------------------------");

        if(boardsService.modify(boardsVO)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("bno", boardsVO.getBno());
        }
        return new RedirectView("read" + criteria.getListLink());
    }

    @PostMapping("remove")
    public RedirectView remove(@RequestParam("bno") Long bno, @RequestParam("boardType") int boardType, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove : " + bno);
        log.info("-------------------------------");
        if (boardsService.remove(bno)) {

            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("list?boardType=" + boardType );


    }

}
