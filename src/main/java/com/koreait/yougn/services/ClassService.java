package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.ClassDAO;
import com.koreait.yougn.beans.dao.ClassThumbDAO;
import com.koreait.yougn.beans.vo.ApplyVO;
import com.koreait.yougn.beans.vo.ClassCri;
import com.koreait.yougn.beans.vo.ClassVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassService {
    private final ClassDAO classDAO;
    private final ClassThumbDAO classThumbDAO;

    //리스트 가져오기
    public List<ClassVO> getList(ClassCri classCri){
        List<ClassVO> list = classDAO.getClassList(classCri);
        for (ClassVO classVO : list) {
            classVO = dateSet(classVO);
        }
        list.forEach(vo -> log.info(vo.toString()));
        return list;
    }

    public ArrayList<String> getSrcList(List<ClassVO> list){
        ArrayList<ThumbVO> thumbArr = new ArrayList<>();
        ArrayList<String> srcArr = new ArrayList<>();
        String temp = null;
        for (ClassVO vo:list) {
            thumbArr.add(classThumbDAO.findByNum(vo.getNum()));
        }
        for (ThumbVO vo:thumbArr) {
            if(vo == null){
             srcArr.add(null);
             continue;
            }
            temp = "classThumb/" + vo.getUploadPath() + "/" + vo.getUuid() + "_" +vo.getFileName();
            srcArr.add(temp);
        }
        return srcArr;
    }

    public String getSrc(Long classNum){
        ThumbVO vo = classThumbDAO.findByNum(classNum);
        return "classThumb/" + vo.getUploadPath() + "/" + vo.getUuid() + "_" +vo.getFileName();
    }

    public ArrayList<ThumbVO> getThumbList(Long classNum){
        ArrayList<ThumbVO> thumbList = new ArrayList<>();
        thumbList.add(classThumbDAO.findByNum(classNum));
        return  thumbList;
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
    @Transactional(rollbackFor = Exception.class)
    public boolean register(ClassVO classVO){
        try {
            classDAO.insert(classVO);
            classVO.getFileList().forEach( thumb -> thumb.setExpoNum(classVO.getNum()));
            classThumbDAO.insert(classVO.getFileList().get(0));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //수정
    @Transactional(rollbackFor = Exception.class)
    public boolean modify(ClassVO classVO){
        boolean modifyResult = false;

        classThumbDAO.deleteAll(classVO.getNum());
        modifyResult = classDAO.update(classVO);
        if(modifyResult && classVO.getFileList() != null && classVO.getFileList().size() != 0){
            classVO.getFileList().forEach( thumb -> {
                thumb.setExpoNum(classVO.getNum());
                classThumbDAO.insert(thumb);
            });
        }
        return modifyResult;
    }



    //클래스 신청
    public boolean apply(ApplyVO applyVO){
        classDAO.applyInsert(applyVO);
        return classDAO.updateCountUp(applyVO.getClassNum());
    }

    //클래스 취소
    public boolean cancel(ApplyVO applyVO){
        log.info("classNum : " + applyVO.getClassNum() );
        classDAO.applyDelete(applyVO);
        return classDAO.updateCountDown(applyVO.getClassNum());
    }

    //클래스를 이미 신청했는지 확인 / true면 신청가능
    public boolean checkApply(ApplyVO applyVO){
        return classDAO.getApply(applyVO) == null;
    }

    //ApplyVO 가져오기
    public String getMerchant_uid(ApplyVO applyVO){
        ApplyVO vo = classDAO.getApply(applyVO);
        return vo == null? "" :  vo.getMerchant_uid();
    }
    public String getImp_uid(ApplyVO applyVO){
        ApplyVO vo = classDAO.getApply(applyVO);
        return vo == null? "" :  vo.getImp_uid();
    }

    //삭제
    public boolean remove(Long num){
        return classDAO.delete(num);
    }

    //전체 글 개수 가져오기
    public int getTotal(ClassCri classCri){
        return classDAO.getTotal(classCri);
    }


    //파일(썸네일) 가져오기
    public ThumbVO getFile(Long classNum){
        return classThumbDAO.findByNum(classNum);
    }
}
