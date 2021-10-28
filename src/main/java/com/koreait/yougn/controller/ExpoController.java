package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.PageDTO;
import com.koreait.yougn.beans.vo.ThumbVO;
import com.koreait.yougn.services.ExpoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/expo/*")
@RequiredArgsConstructor
public class ExpoController {

    private final ExpoService expoService;

    @GetMapping("detailfuck")
    public void detailfuck(){

    }

    /*리스트*/
    @GetMapping("list")
    public String list(Criteria criteria, Model model) {
        model.addAttribute("list", expoService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(expoService.getTotal(criteria), 10, criteria));
        return "/expo/list";

    }

    /*글 작성*/
    //페이지 이동
    @GetMapping("writeExpo")
    public void writeExpo(ExpoVO vo, Criteria criteria, Model model) {
        vo.setUserId("아이디123");
        model.addAttribute("vo", vo);
        model.addAttribute("criteria", criteria);
    }

    //메소드
    @PostMapping("writeExpo")
    public RedirectView register(ExpoVO vo, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("writeExpo : " + vo.toString());
        log.info("-------------------------------");

        if(vo.getAttachList() != null){
            vo.getAttachList().forEach(attach -> log.info(attach.toString()));
        }

        expoService.register(vo);

//        쿼리 스트링으로 전달
//        rttr.addAttribute("bno", boardVO.getBno());
//        세션의 flash영역을 이용하여 전달
        rttr.addFlashAttribute("expoNum", vo.getExpoNum());
//        RedirectView를 사용하면 redirect방식으로 전송이 가능하다.
        return new RedirectView("list");
    }

    //글 수정
    //페이지이동
    @GetMapping("modifyExpo")
    public void modifyExpo(@RequestParam("expoNum") Long expoNum, Criteria criteria, Model model) {
        model.addAttribute("vo", expoService.get(expoNum));
        model.addAttribute("cri", criteria);
    }

    //메소드
    @PostMapping("modifyExpo")
    public RedirectView modifyExpo(Criteria criteria, ExpoVO expoVO, RedirectAttributes rttr) {
        log.info("------------------------------------");
        log.info("modifyExpo--------------------------------------------------");
        log.info("------------------------------------");

        if (expoService.modify(expoVO)) {
            rttr.addAttribute("result", "success");
            rttr.addAttribute("expoNum", expoVO.getExpoNum());
        }
        return new RedirectView("readDetail" + criteria.getListLink());
    }


    //상세보기
    @GetMapping({"readDetail", "modify"})
    public void readDetail(@RequestParam("expoNum") Long expoNum, Criteria criteria, Model model,  HttpServletRequest request) {
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + expoNum);
        log.info("-------------------------------");
        model.addAttribute("expo", expoService.get(expoNum));
        model.addAttribute("criteria", criteria);
    }

    //삭제
    @PostMapping("remove")
    public RedirectView remove(@RequestParam("expoNum") Long expoNum, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove + " + expoNum);
        log.info("-------------------------------");

        List<ThumbVO> attachList = expoService.getAttachList(expoNum);

        if (expoService.remove(expoNum)) {
            deleteFiles(attachList);
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("/expo/list");
    }

    private void deleteFiles(List<ThumbVO> attachList) {
        if (attachList == null || attachList.size() == 0) {
            return;
        }

        log.info("delete attach files...........");
        log.info(attachList.toString());

        attachList.forEach(attach -> {
            try {
                Path file = Paths.get("C:/upload/" + attach.getUploadPath() + "/" + attach.getUuid() + "_" + attach.getFileName());
                Files.delete(file);

                if (Files.probeContentType(file).startsWith("image")) {
                    Path thumbnail = Paths.get("C:/upload/" + attach.getUploadPath() + "/s_" + attach.getUuid() + "_" + attach.getFileName());
                    Files.delete(thumbnail);
                }
            } catch (Exception e) {
                log.error("delete file error " + e.getMessage());
            }
        });

    }

    @GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ThumbVO> getAttachList(Long expoNum){
        log.info("getAttachList " + expoNum);
        return expoService.getAttachList(expoNum);
    }
}
