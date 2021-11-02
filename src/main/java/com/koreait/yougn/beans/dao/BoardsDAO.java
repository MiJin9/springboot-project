package com.koreait.yougn.beans.dao;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.mappers.BoardsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardsDAO {

    private final BoardsMapper mapper;

    public void register(BoardsVO boards){
        mapper.insertSelectKey_bno(boards);
    }

    public BoardsVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BoardsVO boards){
        return mapper.update(boards) == 1;
    }

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<BoardsVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }

    public int plusOne(Long bno){return mapper.plusOne(bno);}

    public List<BoardsVO> getMyList(Criteria criteria){return mapper.getMyList(criteria);}

    public int getMyTotal(Criteria criteria){return mapper.getMyTotal(criteria);}

}
