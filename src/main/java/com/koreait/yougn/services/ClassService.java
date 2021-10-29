package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.ClassDAO;
import com.koreait.yougn.beans.vo.ClassCri;
import com.koreait.yougn.beans.vo.ClassVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassDAO classDAO;

    //리스트 가져오기
    public List<ClassVO> getList(ClassCri classCri){
        List<ClassVO> list = classDAO.getClassList(classCri);
        for (ClassVO classVO : list) {
            classVO = dateSet(classVO);
        }
        return list;
    }

    //하나 가져오기
    public ClassVO getClass(Long num){
        ClassVO classVO = classDAO.getClass(num);
        return dateSet(classVO);
    }


    private ClassVO dateSet(ClassVO classVO){
        classVO.setRecruitCloseDate(classVO.getRecruitCloseDate().split(" ")[0]);
        classVO.setRecruitDate(classVO.getRecruitDate().split(" ")[0]);
        classVO.setOpenDate(classVO.getOpenDate().split(" ")[0]);
        classVO.setCloseDate(classVO.getCloseDate().split(" ")[0]);
        return classVO;
    }

    //등록
    public boolean register(ClassVO classVO){
        return classDAO.insert(classVO);
    }

    //수정
    public boolean modify(ClassVO classVO){
        return classDAO.update(classVO);
    }

    //클래스 신청
    public boolean apply(Long num){
        return classDAO.updateCount(num);
    }

    //삭제
    public boolean remove(Long num){
        return classDAO.delete(num);
    }

    //전체 글 개수 가져오기
    public int getTotal(ClassCri classCri){
        return classDAO.getTotal(classCri);
    }
}
