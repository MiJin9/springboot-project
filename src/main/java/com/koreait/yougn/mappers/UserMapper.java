package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //회원 가입
    public int insert(UserVO userVO);

    //유저정보 가져오기(마이페이지에서 회원정보 뿌릴때 쓰면 될 듯)
    //로그인 할 때 사용 -> 디비에서 가져온 정보랑 입력한 pw랑 비교
    public UserVO getUser(String id);

    //회원정보 수정
    public int updateInfo(UserVO userVO);

    //비밀번호 수정
    public int updatePw(UserVO userVO);

    //회원 탈퇴
    public int updateStatus(UserVO userVO);

    //아이디 찾기
    public List<String> getId(UserVO userVO);

    //비밀번호 찾기
    public int getPw(UserVO userVO);
}
