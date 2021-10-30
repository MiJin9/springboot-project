package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ClassCri;
import com.koreait.yougn.beans.vo.ClassVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public List<ClassVO> selectList(ClassCri classCri);
    public ClassVO select(Long num);
    public int insert(ClassVO classVO);
    public int update(ClassVO classVO);
    public int updateCount(Long num);
    public int delete(Long num);
    public int getTotal(ClassCri classCri);
}
