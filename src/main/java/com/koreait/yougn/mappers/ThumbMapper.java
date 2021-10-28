package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.ThumbVO;

import java.util.List;

public interface ThumbMapper {

    public void insert(ThumbVO thumbVO);
    public void delete(String uuid);
    public List<ThumbVO> findByNum(Long thumbNum);
    public void deleteAll(Long thumbNum);
    public List<ThumbVO> getOldFiles();
}
