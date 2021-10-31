package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ThumbVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThumbMapper {

    public void insert(ThumbVO thumbVO);
    public void delete(String uuid);
    public List<ThumbVO> findByNum(Long expoNum);
    public void deleteAll(Long thumbNum);
    public List<ThumbVO> getOldFiles();
}
