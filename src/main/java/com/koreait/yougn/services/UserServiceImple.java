package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.UserDAO;
import com.koreait.yougn.beans.vo.MailSenderRunner;
import com.koreait.yougn.beans.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

    private final UserDAO userDAO;
    private final MailSenderRunner msr;

    @Override
    public boolean join(UserVO userVO) {
        return userDAO.join(userVO);
    }

    @Override
    public boolean login(UserVO userVO) {
        return userDAO.getUser(userVO.getId()).getPw().equals(userVO.getPw());
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
    public List<String> findId(UserVO userVO) {
        return userDAO.findId(userVO);
    }

    @Override
    public HashSet<String> getEmailList(UserVO userVO) {
        HashSet<String> emailList = new HashSet<>();
        List<String> idList = userDAO.findId(userVO);
        for (int i = 0; i < idList.size(); i++) {
            emailList.add(userDAO.getUser(idList.get(i)).getEmail());
        }
        return emailList;
    }

    @Override
    public void sendEmail(HashSet<String> emailList, String title, String content) {
        for (String email:emailList) {
            try {msr.send(email,title,content);} catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean findPw(UserVO userVO) {
        return userDAO.findPw(userVO);
    }
}