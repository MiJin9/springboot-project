package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpoService {

    public void register(ExpoVO expoVO);

    public ExpoVO get(Long expoNum);

    public boolean modify(ExpoVO expoVO);

    public boolean remove(Long expoNum);

    public List<ExpoVO> getList(Criteria criteria);

    public int getTotal(Criteria criteria);
}
