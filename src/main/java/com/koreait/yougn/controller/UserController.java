package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.*;
import com.koreait.yougn.services.BoardsService;
import com.koreait.yougn.services.FaqService;
import com.koreait.yougn.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    private final UserService userService;
    private final FaqService faqService;
    private final BoardsService boardsService;

    //회원가입
    @GetMapping("join")
    public String join() {
        return "/user/join";
    }

    @PostMapping("join")
    public RedirectView join(UserVO userVO) {
        userService.join(userVO);
        return new RedirectView("/");
    }


    //로그인
    @GetMapping("login")
    public String login() {
        return "/user/login";
    }

    @PostMapping(value = "login", consumes = "application/json; charset=utf-8",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody UserVO userVO, HttpServletRequest r) {
        HashMap<String, Object> map = new HashMap<>();
        if (userService.login(userVO)) {
            UserVO userVO1 = userService.getUser(userVO.getId());
            map.put("user",userVO1);
            if(userVO1.getStatus() != 1){
                r.getSession().setAttribute("sessionId", userVO.getId());
                map.put("result","ok");
            }else{
                map.put("result","no");
            }
        }else {
            map.put("result","no");
        }
        return map;
    }

    //로그아웃
    @RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView logout(HttpServletRequest r) {
        r.getSession().invalidate();
        return new RedirectView("/");
    }

    //마이페이지
    @GetMapping("myPage")
    public String myPage(Model model, HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);

        model.addAttribute("user", user);
        return "/user/myPage";
    }

    //회원 탈퇴
    @PostMapping("byeOk")
    public String bye(HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        userService.singOut(user);
        r.getSession().invalidate();
        return "index";
    }

    @PostMapping("bye")
    public String bye() {
        return "/user/bye";
    }

    //회원정보 수정
    @GetMapping("userModify")
    public String userModify(Model model, HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/userModify";
    }

    //비밀번호 수정
    @PostMapping("changePwOk")
    public RedirectView changePw(String newPw, String id, HttpServletRequest r, RedirectAttributes rttr) {
        UserVO user = userService.getUser(id);

        user.setPw(newPw);
        if (userService.modifyPw(user)) {
            r.getSession().invalidate();
            return new RedirectView("/");
        }

        rttr.addAttribute("result", "비밀번호 변경에 실패하였습니다.");
        return new RedirectView("user/changePw");
    }

    @PostMapping("changePw")
    public String changePw(UserVO userVO, Model model) {
        model.addAttribute("userVO", userVO);
        return "/user/changePw";
    }


    //비밀번호 확인
    @GetMapping("checkPw")
    public String checkPw(int num, Model m) {
        m.addAttribute("num",num);
        return "/user/checkPw";
    }

    @PostMapping(value = "checkPw", consumes = "application/json; charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, String> checkPw(@RequestBody UserVO userVO, HttpServletRequest r) {

        HashMap<String, String> map = new HashMap<>();

        if (userService.getUser(userVO.getId()).getPw().equals(userVO.getPw())) {
            map.put("result", "성공");
            return map;
        }

        map.put("result", "비밀번호가 일치하지 않습니다.");
        return map;
    }

    //ID,PW 찾기
    @GetMapping("findUser")
    public String findUser() {
        return "user/findUser";
    }


    //아이디 중복확인
    @PostMapping(value = "{id}", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> checkId(@PathVariable("id") String id) throws UnsupportedEncodingException {
        log.info(id);
        return userService.checkId(id) ? new ResponseEntity<>(new String("사용 가능".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(new String("사용 불가".getBytes(), "UTF-8"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //회원정보 수정
    @PostMapping("userModify")
    public String userModify(UserVO user, Model model) {
        if (userService.modifyUserInfo(user)) {
            model.addAttribute("user", userService.getUser(user.getId()));
            return "user/myPage"; //성공..
        }
        model.addAttribute("result", "fail");
        model.addAttribute("user", user);
        return "user/userModify"; // 실~패!
    }

    //아이디 찾기(인증번호 보내기)
    @PostMapping(value = "idPin", consumes = "application/json; charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String,String> idPin(@RequestBody UserVO userVO) throws UnsupportedEncodingException{
        log.info("findUser------------");
        List<String> idList = userService.findId(userVO);
        HashMap<String,String> map = new HashMap<>();
        if (idList.size() == 0 || idList == null){
            map.put("result","일치하는 정보가 없습니다.");
            return map;
        }
        String pin = makePin();
        String title = "유귀농 아이디 찾기 인증번호";
        String content = "유귀농 아이디 찾기 인증번호입니다. 노출되지 않게 유의 부탁드립니다.\n인증번호 : " +pin;
        if(userService.sendEmail(userService.getEmailList(userVO),title,content)){
            map.put("pin",pin);
            map.put("result","이메일을 확인해주세요.");
            return map;
        }
        map.put("result","이메일 전송에 실패하였습니다.");
        return map;
    }

    //아이디 보내기
    @PostMapping(value = "sendId", consumes = "application/json; charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String,String> sendId(@RequestBody UserVO userVO) throws UnsupportedEncodingException{
        log.info("sendId------------");
        List<String> idList = userService.findId(userVO);
        HashMap<String,String> map = new HashMap<>();
        if (idList.size() == 0 || idList == null){
            map.put("result","일치하는 정보가 없습니다.");
            return map;
        }
        String title = "유귀농 아이디 찾기";
        String content = "유귀농 아이디 찾기 입니다. 노출되지 않게 유의 부탁드립니다.\n";

        for (int i = 0; i < idList.size() ; i++) {
            content += idList.get(i)+"\n";
        }
        content += "입니다.";

        if(userService.sendEmail(userService.getEmailList(userVO),title,content)){
            map.put("result","이메일을 확인해주세요.");
            return map;
        }
        map.put("result","이메일 전송에 실패하였습니다.");
        return map;
    }

    //비밀번호 찾기(인증번호 보내기)
    @PostMapping(value = "pwPin", consumes = "application/json; charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String,String> pwPin(@RequestBody UserVO userVO) throws UnsupportedEncodingException{
        HashMap<String,String> map = new HashMap<>();

        if(!userService.findPw(userVO)){
            map.put("result","정보가 일치하지 않습니다.");
            return map;
        }

        String pin = makePin();
        String title = "유귀농 비밀번호 찾기 인증번호";
        String content = "유귀농 비밀번호 찾기 인증번호입니다. 노출되지 않게 유의 부탁드립니다.\n인증번호 : " +pin;
        if(userService.sendEmail(userService.getEmailList(userVO),title,content)){
            map.put("pin",pin);
            map.put("result","이메일을 확인해주세요.");
            return map;
        }
        map.put("result","이메일 전송에 실패하였습니다.");
        return map;
    }

    //    인증번호 만들기
    private String makePin() {
        String nums = "0123456789";
        String pin = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            pin += nums.charAt(random.nextInt(10));
        }
        return pin;
    }

    //인증문자 보내기
    @PostMapping("sendSMS")
    @ResponseBody
    public HashMap<String, String> sendSMS(String phoneNumber) {
        Random rand = new Random();
        HashMap<String, String> map = new HashMap<>();
        String numStr = "";
        for (int i = 0; i < 6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }

        userService.certified(phoneNumber, numStr);
        map.put("result", "번호가 전송되었습니다.");
        map.put("numStr", numStr);

        return map;
    }

    //문의글 목록
    @GetMapping("inquiry")
    public String inquiry(Criteria criteria, Model model, HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);

        model.addAttribute("list", faqService.getListId(criteria, user.getId()));
        model.addAttribute("pageMaker", new PageDTO(faqService.getTotalId(criteria, user.getId()), 10, criteria));
        return "user/inquiry";
    }

    //문의글 작성
    @PostMapping("inquiryWrite")
    public RedirectView inquiryWrite(FaqVO faqVO, RedirectAttributes rttr) {
        faqService.register(faqVO);

        rttr.addFlashAttribute("num", faqVO.getNum());
        return new RedirectView("inquiry");
    }

    @GetMapping("inquiryWrite")
    public void inquiryWrite(){}

    //문의글 상세보기
    @GetMapping("inquiryRead")
    public void inquiryRead(@RequestParam("num") Long num,  Criteria criteria, Model model) {
        model.addAttribute("faq", faqService.get(num));
        model.addAttribute("criteria", criteria);
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody FaqVO faqVO) throws UnsupportedEncodingException {
        int replyCount = faqService.insertReply(faqVO);
        log.info("faqVO : " + faqVO);
        log.info("REPLY INSERT COUNT : " + replyCount);
        return replyCount == 1 ?
                new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //게시글 댓글 전체 조회
    @GetMapping("pages/{num}")
    public FaqVO getList(@PathVariable("num") Long num){
        return faqService.readReply(num);
    }


    //문의글 삭제
    @PostMapping("remove")
    public RedirectView remove(@RequestParam("num") Long num, RedirectAttributes rttr, HttpServletRequest r){
        String id = (String)r.getSession().getAttribute("sessionId");
        if(faqService.remove(num)){
            rttr.addFlashAttribute("result", "success");
        } else{
            rttr.addFlashAttribute("result", "fail");
        }
        if(id.equals("yougnAdmin")) {
            return new RedirectView("inquiryAdmin");
        }
        return new RedirectView("inquiry");
    }

    //관리자 페이지
    @GetMapping("admin")
    public String admin(Criteria criteria, Model model, HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);

        model.addAttribute("list", faqService.getListId(criteria, user.getId()));
        model.addAttribute("pageMaker", new PageDTO(faqService.getTotalId(criteria, user.getId()), 10, criteria));
        return "user/admin";
    }

    //1:1문의 목록 - 관리자
    @GetMapping("inquiryAdmin")
    public String inquiryAdmin(Criteria criteria, Model model) {

        model.addAttribute("list", faqService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(faqService.getTotal(criteria), 10, criteria));
        return "user/inquiryAdmin";
    }

    //내 글 모아보기
    @GetMapping("myList")
    public String myList(Criteria criteria,Model model, HttpServletRequest r) {
        String id = (String) r.getSession().getAttribute("sessionId");
        criteria.setKeyword(id);

        model.addAttribute("myList", boardsService.getMyList(criteria));
        model.addAttribute("pageMaker", new PageDTO(boardsService.getMyTotal(criteria), 10, criteria));
        return "user/myList";
    }

}
