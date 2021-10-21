package com.koreait.yougn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
                                                                    
    /*공지*/
    @GetMapping("notice")     // 공지사항 리스트
    public String notice(){return "/board/notice/notice";}

    /*수매*/
    @GetMapping("buyAndSell")   // 수매 리스트
    public String buyAndSell(){
        return "/board/buyAndSell/buyAndSell";
    }

    @GetMapping("buyRead")     // 삽니다 상세 보기
    public String buyRead(){return "/board/buyAndSell/buyRead";}

    @GetMapping("sellRead")     // 팝니다 상세 보기
    public String sellRead(){return "/board/buyAndSell/sellRead";}

    @GetMapping("buyWrite")    // 삽니다 글 작성
    public String buyWrite(){return "/board/buyAndSell/buyWrite";}

    @GetMapping("sellWrite")    // 팝니다 글 작성
    public String sellWrite(){return "/board/buyAndSell/sellWrite";}

    @GetMapping("buyModify")    // 삽니다 글 수정
    public String buyModify(){return "/board/buyAndSell/buyModify";}

    @GetMapping("sellModify")    // 팝니다 글 수정
    public String sellModify(){return "/board/buyAndSell/sellModify";}

    /*임대 매매*/
    @GetMapping("rentalAndSale") // 임대 매매 리스트
    public String rentalAndSale(){return "/board/rentalAndSale/rentalAndSale";}

    @GetMapping("rentalRead")     // 임대 상세 보기
    public String rentalRead(){return "/board/rentalAndSale/rentalRead";}

    @GetMapping("saleRead")     // 매매 상세 보기
    public String saleRead(){return "/board/rentalAndSale/saleRead";}

    @GetMapping("rentalWrite")    // 임대 글 작성
    public String rentalWrite(){return "/board/rentalAndSale/rentalWrite";}

    @GetMapping("saleWrite")    // 매매 글 작성
    public String saleWrite(){return "/board/rentalAndSale/saleWrite";}

    @GetMapping("rentalModify")    // 임대 글 수정
    public String rentalModify(){return "/board/rentalAndSale/rentalModify";}

    @GetMapping("saleModify")    // 매매 글 수정
    public String saleModify(){return "/board/rentalAndSale/saleModify";}

    /*고인물*/
    @GetMapping("qnaList") // 지식인 리스트
    public String qnaList(){return "/board/goinmool/qnaList";}

    @GetMapping("qnaRead")     // 지식인 상세 보기
    public String qnaView(){return "/board/goinmool/qnaRead";}

    @GetMapping("qnaRegister")    // 지식인 글 작성
    public String qnaRegister(){return "/board/goinmool/qnaRegister";}

    @GetMapping("qnaModify")    // 지식인 글 작성
    public String qnaModify(){return "/board/goinmool/qnaModify";}

}
