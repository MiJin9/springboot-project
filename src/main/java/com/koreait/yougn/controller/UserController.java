package com.koreait.yougn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    @GetMapping("join")
    public String join() {
        return "/user/join";
    }

    @GetMapping("login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("myPage")
    public String myPage() {
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
    public String userModify() {
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
}
