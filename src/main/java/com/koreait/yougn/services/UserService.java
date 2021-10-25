package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //회원 가입
    public boolean join(UserVO userVO);

    //로그인
    public boolean login(UserVO userVO);

    //아이디 중복확인
    public  boolean checkId(String id);

    //회원정보 모두 가져오기
    public UserVO getUser(String id);

    //회원정보 수정
    public boolean modifyUserInfo(UserVO userVO);

    //비밀번호 수정
    public boolean modifyPw(UserVO userVO);

    //회원 탈퇴
    public boolean singOut(UserVO userVO);

    //아이디 찾기
    public List<String> fintId(UserVO userVO);

    //비밀번호 찾기
    public boolean findPw(UserVO userVO);
}
