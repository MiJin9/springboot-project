package com.koreait.yougn;

import com.koreait.yougn.beans.vo.UserVO;
import com.koreait.yougn.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO user = new UserVO();
        user.setId("hds1234");
        user.setPw("1234");
        user.setName("ted-Han");
        user.setEmail("email@google.com");
        user.setPhone("01043825111");
        user.setAddress("경기도 남양주시 화도읍");
        user.setAddressDetail("");
        userMapper.insert(user);
    }

    @Test
    public void getUserTest(){
        log.info(userMapper.getUser("hds1234").toString());
    }

    @Test
    public void updateInfoTest(){
        UserVO user = new UserVO();
        user.setId("hds1234");
        user.setPw("1234");
        user.setName("ted-Han");
        user.setEmail("email@google.com");
        user.setPhone("01043825111");
        user.setAddress("경기도 남양주시 화도읍");
        user.setAddressDetail("휘게 타운 하우스");
        userMapper.updateInfo(user);
    }

    @Test
    public void updatePwTest(){
        UserVO user = new UserVO();
        user.setId("hds1234");
        user.setPw("1111");
        userMapper.updatePw(user);
    }

    @Test
    public void updateStatusTest(){
        UserVO user = new UserVO();
        user.setId("hds1234");
        user.setStatus(1);
        userMapper.updateStatus(user);
    }

    @Test
    public void getIdTest(){
        UserVO user = new UserVO();
        user.setName("ted-Han");
        user.setPhone("01043825111");
        userMapper.getId(user).forEach(id -> log.info(id.toString()));
    }

    @Test
    public void getPwTest(){
        UserVO user = new UserVO();
        user.setId("hds1234");
        user.setPhone("01043825111");
        log.info("find pw count : " + userMapper.getPw(user));
    }
}
