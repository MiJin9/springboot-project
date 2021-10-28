package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ThumbMapperTest {

    @Autowired
    private  ThumbMapper thumbMapper;

    /* INSERT INTO T_THUMB(UUID, UPLOADPATH, THUMBNUM, THUMBNAME, IMAGE)
        VALUES (#{uuid}, #{uploadPath}, #{thumbNum}, #{thumbName}, #{image})*/

    @Test
    public void testInsert(){
        ThumbVO t = new ThumbVO();
        t.setUuid("123123");
        t.setUploadPath("3123");
        t.setExpoNum(3L);
        t.setFileName("asdasd");
        t.setImage(true);
        thumbMapper.insert(t);
    }
}
