package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ThumbVO;
import com.koreait.yougn.mappers.ThumbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThumbDAO {

    @Autowired
    private ThumbMapper thumbMapper;

    public void insert(ThumbVO thumbVO){thumbMapper.insert(thumbVO);}

    public void delete(String uuid){thumbMapper.delete(uuid);}

    public List<ThumbVO> findByNum(Long thumbNum){return thumbMapper.findByNum(thumbNum);}

    public void deleteAll(Long thumbNum){thumbMapper.deleteAll(thumbNum);}

    public List<ThumbVO> getOldFiles() {return thumbMapper.getOldFiles();}

}
