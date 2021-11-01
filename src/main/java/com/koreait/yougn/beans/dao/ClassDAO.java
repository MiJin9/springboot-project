package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ApplyCri;
import com.koreait.yougn.beans.vo.ApplyVO;
import com.koreait.yougn.beans.vo.ClassCri;
import com.koreait.yougn.beans.vo.ClassVO;
import com.koreait.yougn.mappers.ClassMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClassDAO {

    private final ClassMapper classMapper;

    public List<ClassVO> getClassList(ClassCri classCri){return classMapper.selectList(classCri);}
    public ClassVO getClass(Long num){return classMapper.select(num);}
    public boolean insert(ClassVO classVO){return classMapper.insert(classVO) == 1;}
    public boolean update(ClassVO classVO){
        int result = classMapper.update(classVO);
        log.info("update result : " + result);
        return result == 1;
    }
    public boolean updateCountUp(Long num){return classMapper.updateCountUp(num) == 1;}
    public boolean updateCountDown(Long num){return classMapper.updateCountDown(num) == 1;}
    public boolean delete(Long num){return classMapper.delete(num) == 1;}
    public int getTotal(ClassCri classCri){return classMapper.getTotal(classCri);}

    public boolean applyInsert(ApplyVO applyVO){return classMapper.applyInsert(applyVO) == 1;}
    public boolean applyDelete(ApplyVO applyVO){return classMapper.applyDelete(applyVO) == 1;}
    public List<Integer> getApplyList(ApplyCri applyCri){return classMapper.selectApplyList(applyCri);}
    public ApplyVO getApply(ApplyVO applyVO){return classMapper.selectApply(applyVO);}
    public int getApplyTotal(String id){return classMapper.getApplyTotal(id);}

}
