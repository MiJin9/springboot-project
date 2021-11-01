package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.*;
import com.koreait.yougn.services.ClassService;
import com.koreait.yougn.services.HallService;
import com.koreait.yougn.services.ReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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

    @GetMapping("testPage1")
    public String testPage1(){return "/testPage1";}
    @GetMapping("testPage2")
    public String testPage2(){return "/testPage2";}
    @GetMapping("test")
    public String getJsp(){return "/test.jsp";}


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

    @RequestMapping(value = "classList",method = {RequestMethod.GET,RequestMethod.POST})
    public String classList(ClassCri classCri, HttpServletRequest r, Model model){
        String id = (String)r.getSession().getAttribute("sessionId");
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
        model.addAttribute("id",id==null?"":id);
        model.addAttribute("list", list);
        model.addAttribute("srcList",classService.getSrcList(list));
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
    public void classView(Long num, HttpServletRequest r,Model model){
        String id = (String)r.getSession().getAttribute("sessionId");
        log.info("id : " + id);
        ClassVO classVO = classService.getClass(num);

        ApplyVO applyVO = new ApplyVO();
        applyVO.setId(id);
        applyVO.setClassNum(num);

        model.addAttribute("merchant_uid",classService.getMerchant_uid(applyVO));
        model.addAttribute("applyCheck",classService.checkApply(applyVO));
        model.addAttribute("check" , classVO.getRecruitDate().compareTo(getToday()) <= 0);
        model.addAttribute("class",classVO);
        model.addAttribute("src",classService.getSrc(classVO.getNum()));
    }

    // 결제 완료 후 merchant_uid를 받아서 요청을 보냄
    // 클래스 신청
    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "apply",consumes = "application/json; charset=utf-8",produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> apply(@RequestBody ApplyVO applyVO, HttpServletRequest r) throws UnsupportedEncodingException {
        String id = (String)r.getSession().getAttribute("sessionId");
        applyVO.setId(id);
        return classService.apply(applyVO)? new ResponseEntity<>(new String("신청 완료".getBytes(),"UTF-8"), HttpStatus.OK):
                new ResponseEntity<>(new String("신청 실패".getBytes(),"UTF-8"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 클래스 취소
    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "cancel",consumes = "application/json; charset=utf-8",produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> cancel(@RequestBody ApplyVO applyVO, HttpServletRequest r) throws UnsupportedEncodingException {
        String id = (String)r.getSession().getAttribute("sessionId");
        applyVO.setId(id);
        return classService.cancel(applyVO)? new ResponseEntity<>(new String("취소 완료".getBytes(),"UTF-8"), HttpStatus.OK):
                new ResponseEntity<>(new String("취소 실패".getBytes(),"UTF-8"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("classRegister")
    public void classRegister(){}

    @PostMapping("classRegister")
    public RedirectView classRegister(ClassVO classVO, @RequestParam("addressDetail") String addressDetail, Model model){
        addressDetail = addressDetail == null? "" : addressDetail;
        classVO.setAddress(classVO.getAddress() + " " + addressDetail);
        classService.register(classVO);
        model.addAttribute("pageNum", 1);
        model.addAttribute("amount",10);
        return new RedirectView("classList");
    }

    @GetMapping("classModify")
    public void classModify(Long num, Model model){
        ClassVO classVO = classService.getClass(num);
        model.addAttribute("class",classVO);
        model.addAttribute("thumbList",classService.getThumbList(classVO.getNum()));
    }

    @PostMapping("classModify")
    public RedirectView classModify(ClassVO classVO, RedirectAttributes rttr){
        if(classService.modify(classVO)){
            rttr.addAttribute("num",classVO.getNum());
        }
        return new RedirectView("classView");
    }

    @GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<ThumbVO> getAttachList(Long classNum){
        return classService.getThumbList(classNum);
    }

    @GetMapping("infoList")
    public String infoList(){return "support/infoList";}

    @GetMapping("home")
    public String home(){ return "home";}
}
