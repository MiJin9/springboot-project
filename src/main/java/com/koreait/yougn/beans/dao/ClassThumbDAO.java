package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.ThumbVO;
import com.koreait.yougn.mappers.ClassThumbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClassThumbDAO {

    private final ClassThumbMapper classThumbMapper;

    public void insert(ThumbVO thumbVO){classThumbMapper.insert(thumbVO);}
    public void delete(String uuid){classThumbMapper.delete(uuid);}
    public ThumbVO findByNum(Long expoNum){return classThumbMapper.findByNum(expoNum);}
    public void deleteAll(Long expoNum){classThumbMapper.deleteAll(expoNum);}
    public List<ThumbVO> getOldFiles(){return classThumbMapper.getOldFiles();}
}
