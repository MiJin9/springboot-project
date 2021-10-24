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

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardsService boardsService;

    /*리스트*/
    @GetMapping("list")
    public String list(@RequestParam("type") int type, Criteria criteria, Model model){
        criteria.setBoardType(type);
        model.addAttribute("list", boardsService.getList(criteria));    // 목록
        model.addAttribute("pageMaker", new PageDTO(boardsService.getTotal(criteria), 10, criteria));   //페이징
        return "/board/list";
    }

    /*상세보기*/
    @GetMapping("read")
    public void read(@RequestParam("bno") Long bno,  Criteria criteria, Model model, HttpServletRequest request){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);

        model.addAttribute("board", boardsService.get(bno));
        model.addAttribute("criteria", criteria);
    }

    /* 글 작성 */
    @GetMapping("write")
    public void write(BoardsVO vo, Model model){
        vo.setId("이렇게"); // 로그인 된 아이디
        model.addAttribute("vo", vo);
    }

    @PostMapping("write")
    public RedirectView write(BoardsVO boardsVO, RedirectAttributes rttr){
        boardsVO.setId("이렇게");
        boardsService.register(boardsVO);
        rttr.addFlashAttribute("bno",boardsVO.getBno());
        return new RedirectView("list?type=" + boardsVO.getType());
    }

    @GetMapping("buyWrite")    // 삽니다 글 작성
    public String buyWrite(){return "/board/buyAndSell/buyWrite";}

    @GetMapping("sellWrite")    // 팝니다 글 작성
    public String sellWrite(){return "/board/buyAndSell/sellWrite";}

    @GetMapping("rentalWrite")    // 임대 글 작성
    public String rentalWrite(){return "/board/rentalAndSale/rentalWrite";}

    @GetMapping("saleWrite")    // 매매 글 작성
    public String saleWrite(){return "/board/rentalAndSale/saleWrite";}

    @GetMapping("qnaRegister")    // 지식인 글 작성
    public String qnaRegister(){return "/board/goinmool/qnaRegister";}


    /*글 수정*/
    @GetMapping("buyModify")    // 삽니다 글 수정
    public String buyModify(){return "/board/buyAndSell/buyModify";}

    @GetMapping("sellModify")    // 팝니다 글 수정
    public String sellModify(){return "/board/buyAndSell/sellModify";}

    @GetMapping("rentalModify")    // 임대 글 수정
    public String rentalModify(){return "/board/rentalAndSale/rentalModify";}

    @GetMapping("saleModify")    // 매매 글 수정
    public String saleModify(){return "/board/rentalAndSale/saleModify";}

    @GetMapping("qnaModify")    // 지식인 글 수정
    public String qnaModify(){return "/board/goinmool/qnaModify";}

}
