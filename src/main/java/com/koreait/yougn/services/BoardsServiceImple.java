package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.BoardsDAO;
import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardsServiceImple implements BoardsService {

    private final BoardsDAO boardsDAO;

    @Override
    public void register(BoardsVO board) {
        boardsDAO.register(board);
    }

    //상세보기
    @Override
    public BoardsVO get(Long bno) {
        boardsDAO.plusOne(bno); // 조회수 + 1
        return boardsDAO.get(bno);
    }

    @Override
    public boolean modify(BoardsVO board) {
        return boardsDAO.modify(board);
    }

    @Override
    public boolean remove(Long bno) {
        return boardsDAO.remove(bno);
    }

    //리스트
    @Override
    public List<BoardsVO> getList(Criteria criteria) {
        List<BoardsVO> list = boardsDAO.getList(criteria);
                for(BoardsVO vo : list){
                    vo.setRegDate(vo.getRegDate().split(" ")[0]);
                    vo.setUpdateDate(vo.getUpdateDate().split(" ")[0]);
                }
        return list;
    }

    @Override
    public int getTotal(Criteria criteria) {
        return boardsDAO.getTotal(criteria);
    }

    @Override
    public List<BoardsVO> getMyList(Criteria criteria) {
        List<BoardsVO> mylist = boardsDAO.getMyList(criteria);
            for (BoardsVO vo : mylist){
                vo.setRegDate(vo.getRegDate().split(" ")[0]);
                vo.setUpdateDate(vo.getUpdateDate().split(" ")[0]);
            }
        return mylist;
    }

    @Override
    public int getMyTotal(Criteria criteria) { return boardsDAO.getMyTotal(criteria);}


}
