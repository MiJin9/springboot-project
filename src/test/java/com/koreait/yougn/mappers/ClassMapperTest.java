package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ClassCri;
import com.koreait.yougn.beans.vo.ClassVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
@Slf4j
public class ClassMapperTest {

    @Autowired
    private ClassMapper classMapper;

    @Test
    public void insertTest(){
        ClassVO classVO = new ClassVO();
        classVO.setName("한동석");
        classVO.setTitle("샷건 농사3");
        classVO.setPrice(5000000);
        classVO.setPlace("비대면");
        classVO.setAddress("");
        classVO.setContent("coding 농사");
        classVO.setHeadNum(30);
        classVO.setOpenDate("2021-11-18");
        classVO.setCloseDate("2022-03-20");
        classVO.setStartTime("09:00");
        classVO.setEndTime("18:00");
        classVO.setRecruitDate("2021-11-01");
        classVO.setRecruitCloseDate("2021-11-17");

        classMapper.insert(classVO);
    }

    @Test
    public void selectTest(){
        log.info(classMapper.select(1L).toString());;
    }

    @Test
    public void selectListTest(){
        ClassCri classCri = new ClassCri();
//        classCri.setKeyword("coding");
        List<ClassVO> list = classMapper.selectList(classCri);
        for (ClassVO classVO : list) {
            classVO.setRecruitCloseDate(classVO.getRecruitDate().split(" ")[0]);
            classVO.setRecruitDate(classVO.getRecruitDate().split(" ")[0]);
            classVO.setOpenDate(classVO.getOpenDate().split(" ")[0]);
            classVO.setCloseDate(classVO.getCloseDate().split(" ")[0]);
        }
        list.forEach(vo -> log.info(vo.toString()));
    }

    @Test
    public void updateTest(){
        ClassVO classVO = classMapper.select(3L);
        classVO.setContent("수정 테스트22");
        classVO.setTitle("수정 테스트22");
        classVO.setRecruitCloseDate(classVO.getRecruitDate().split(" ")[0]);
        classVO.setRecruitDate(classVO.getRecruitDate().split(" ")[0]);
        classVO.setOpenDate(classVO.getOpenDate().split(" ")[0]);
        classVO.setCloseDate(classVO.getCloseDate().split(" ")[0]);
        classMapper.update(classVO);
    }


    @Test
    public void deleteTest(){
        classMapper.delete(1L);

    }

    @Test
    public void compareTest(){
        List<ClassVO> list = classMapper.selectList(new ClassCri());
        Calendar c = Calendar.getInstance();
        String today = "" + c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
        log.info(today);
        log.info("Calendar.DATE : "+c.get(Calendar.DATE)+"");
        for (ClassVO vo: list) {
            log.info(vo.getRecruitCloseDate().split(" ")[0]);
            log.info(today);
            log.info(vo.getRecruitCloseDate().split(" ")[0].compareTo(today)+"");
            today = "2021-06-30";
        }
    }
}
