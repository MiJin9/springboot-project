package com.koreait.yougn.controller;

import com.koreait.yougn.beans.vo.MailSenderRunner;
import com.koreait.yougn.beans.vo.UserVO;
import com.koreait.yougn.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
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

    @GetMapping("join")
    public String join() {
        return "/user/join";
    }

    @GetMapping("login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("myPage")
    public String myPage(Model model, HttpServletRequest r) {
        String id = (String)r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        model.addAttribute("user",user);
        return "/user/myPage";
    }

    @GetMapping("writeCollection")
    public String writeCollection() {
        return "/user/writeCollection";
    }

    @GetMapping("bye")
    public String bye() {
        return "/user/bye";
    }

    @GetMapping("userModify")
    public String userModify(Model model, HttpServletRequest r) {
        String id = (String)r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        model.addAttribute("user",user);
        return "/user/userModify";
    }

    @GetMapping("changePw")
    public String changePw() {
        return "/user/changePw";
    }

    @GetMapping("inquiry")
    public String inquiry() {return "/user/inquiry";}

    @GetMapping("checkPw")
    public String checkPw() {return "/user/checkPw";}

    @GetMapping("findUser")
    public String findUser() {return "user/findUser";}

    //회원 가입
    @PostMapping("join")
    public String join(UserVO userVO){
        userService.join(userVO);
        return "index";
    }

    //로그인
    @PostMapping("login")
    public String login(UserVO userVO, HttpServletRequest r, Model model){
        if(userService.login(userVO)){
            r.getSession().setAttribute("sessionId", userVO.getId());
            return "index";
        }
        model.addAttribute("result", false);
        return "login";
    }
    //아이디 중복확인
    @PostMapping(value = "{id}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkId(@PathVariable("id") String id) throws UnsupportedEncodingException {
        return userService.checkId(id) ? new ResponseEntity<>(new String("사용 가능".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(new String("사용 불가".getBytes(),"UTF-8"),HttpStatus.OK);
    }


    //회원정보 수정
    @PostMapping("userModify")
    public String userModify(UserVO user,Model model){
        if(userService.modifyUserInfo(user)){
            model.addAttribute("result","success");
            model.addAttribute("user",userService.getUser(user.getId()));
            return "user/userModify";
        }
        model.addAttribute("result","fail");
        model.addAttribute("user",user);
        return "user/userModify";
    }

    //비밀번호 수정
    @PostMapping("changePw")
    public String changePw(String pw, String newpPw,HttpServletRequest r,Model model){
        String id = (String)r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        if(!user.getPw().equals(pw)){
            model.addAttribute("result","현재 비밀번호가 일치하지 않습니다.");
            return "user/changePw";
        }
        user.setPw(newpPw);
        if(userService.modifyPw(user)){
            r.getSession().invalidate();
            return "index";
        }
        model.addAttribute("result","비밀번호 변경에 실패하였습니다.");
        return "user/changePw";
    }

    //회원 탈퇴
    @PostMapping("bye")
    public String bye(HttpServletRequest r){
        String id = (String)r.getSession().getAttribute("sessionId");
        UserVO user = userService.getUser(id);
        userService.singOut(user);
        r.getSession().invalidate();
        return "index";
    }

    private MailSenderRunner msr;
    //아이디 찾기(인증번호 보내기)
//    @PostMapping(value = "findUser", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> findUser(UserVO userVO) throws UnsupportedEncodingException{
//        List<String> idList = userService.fintId(userVO);
//        if (idList.size() == 0 || idList == null){
//            return new ResponseEntity<>("result", "일치하는 정보가 없습니다.");
//        }
//        String pin = makePin();
//        String title = "";
//        String to = userService.getUser(userVO.getId()).getEmail();
//        HashMap<String, String> emails = new HashMap<>();
//        emails.put(userVO.getName(), to);
//        emails.forEach((name, email) -> {
//            msr.send(to, title, pin);
//        });
//    }

    //    인증번호 만들기
    private String makePin(){
        String nums = "0123456789";
        String pin = "";
        Random random = new Random();
        for (int i=0; i <6; i++){
            pin += nums.charAt(random.nextInt(10));
        }
        return pin;
    }


//비밀번호 찾기
}