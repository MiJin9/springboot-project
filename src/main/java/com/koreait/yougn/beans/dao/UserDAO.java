package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.UserVO;
import com.koreait.yougn.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UserMapper userMapper;

    //회원 가입
    public boolean join(UserVO userVO){return userMapper.insert(userVO) == 1;}

    //유저정보 가져오기
    public UserVO getUser(String id){return userMapper.getUser(id);}

    //회원정보 수정
    public boolean modifyInfo(UserVO userVO){return userMapper.updateInfo(userVO) == 1;}

    //비밀번호 수정
    public boolean modifyPw(UserVO userVO){return userMapper.updatePw(userVO) == 1;}

    //회원 탈퇴
    public boolean signOut(UserVO userVO){return userMapper.updateStatus(userVO) == 1;}

    //아이디 찾기
    public List<String> findId(UserVO userVO){return userMapper.getId(userVO);}

    //비밀번호 찾기
    public boolean findPw(UserVO userVO){return userMapper.getPw(userVO) == 1;}
}
