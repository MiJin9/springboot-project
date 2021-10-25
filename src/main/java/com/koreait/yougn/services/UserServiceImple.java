package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.UserDAO;
import com.koreait.yougn.beans.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService{

    private final UserDAO userDAO;

    @Override
    public boolean join(UserVO userVO) {
        return userDAO.join(userVO);
    }

    @Override
    public boolean login(UserVO userVO) {
        return userDAO.getUser(userVO.getId()).equals(userVO.getPw());
    }

    @Override
    public boolean checkId(String id) {
        return userDAO.getUser(id) == null;
    }

    @Override
    public UserVO getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public boolean modifyUserInfo(UserVO userVO) {
        return userDAO.modifyInfo(userVO);
    }

    @Override
    public boolean modifyPw(UserVO userVO) {
        return userDAO.modifyPw(userVO);
    }

    @Override
    public boolean singOut(UserVO userVO) {
        return userDAO.signOut(userVO);
    }

    @Override
    public List<String> fintId(UserVO userVO) {
        return userDAO.fingId(userVO);
    }

    @Override
    public boolean findPw(UserVO userVO) {
        return userDAO.findPw(userVO);
    }
}
