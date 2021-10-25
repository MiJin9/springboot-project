package com.koreait.yougn.services;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;

import java.util.List;

public interface BoardsService {
    public void register(BoardsVO board);
    public BoardsVO get(Long bno);
    public boolean modify(BoardsVO board);
    public boolean remove(Long bno);
    public List<BoardsVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
}
