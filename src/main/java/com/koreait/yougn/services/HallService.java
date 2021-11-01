package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.HallDAO;
import com.koreait.yougn.beans.vo.HallCri;
import com.koreait.yougn.beans.vo.HallVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallDAO hallDAO;

    public List<HallVO> getList(HallCri hallCri){
        return hallDAO.getList(hallCri);
    }

    public int getTotal(HallCri hallCri){
        return hallDAO.getTotal(hallCri);
    }
}
