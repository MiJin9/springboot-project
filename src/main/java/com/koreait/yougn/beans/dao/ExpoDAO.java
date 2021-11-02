package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.mappers.ExpoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpoDAO {

    @Autowired
    private ExpoMapper mapper;

    public void register(ExpoVO expoVO){
        mapper.insertSelectKey_expoNum(expoVO);
    }

    public ExpoVO get(Long expoNum){
        return mapper.read(expoNum);
    }

    public boolean modify(ExpoVO expoVO){
        return mapper.update(expoVO) == 1;
    }

    public boolean remove(Long expoNum){
        return mapper.delete(expoNum) == 1;
    }

    public List<ExpoVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }

}
