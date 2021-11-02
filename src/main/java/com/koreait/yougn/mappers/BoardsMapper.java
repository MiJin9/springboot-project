package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardsMapper {
    //    게시글 목록
    public List<BoardsVO> getList(Criteria criteria);
    //    게시글 추가
    public void insert(BoardsVO board);
    //    게시글 추가(PK가져오기)
    public void insertSelectKey_bno(BoardsVO board);
    //    게시글 상세보기(특정 게시글 정보)
    public BoardsVO read(Long bno);
    //    게시글 수정
    public int update(BoardsVO board);
    //    게시글 삭제
    public int delete(Long bno);
    //    게시글 전체 개수
    public int getTotal(Criteria criteria);

    //조회수 1증가
    public int plusOne(Long bno);

    //내 글 모아보기
    public List<BoardsVO> getMyList(Criteria criteria);

    //내 글 모아보기 페이징
    public int getMyTotal(Criteria criteria);
}
