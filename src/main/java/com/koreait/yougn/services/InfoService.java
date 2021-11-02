package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.InfoDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.InfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final InfoDAO infoDAO;

    public List<InfoVO> getInfoList(Criteria criteria){return infoDAO.getInfoList(criteria);}
    public int getTotal(){return infoDAO.getTotal();}
}
