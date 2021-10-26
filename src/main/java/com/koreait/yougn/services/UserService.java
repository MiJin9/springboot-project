package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public List<String> findId(UserVO userVO);

    //이메일 리스트 가져오기
    public HashSet<String> getEmailList(UserVO userVO);

    //이메일 보내기
    public void sendEmail(HashSet<String> emailList, String title, String content);

    //비밀번호 찾기
    public boolean findPw(UserVO userVO);
}
