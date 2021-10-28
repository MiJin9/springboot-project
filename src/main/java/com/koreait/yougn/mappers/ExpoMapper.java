package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpoMapper {
    //    게시글 목록
    public List<ExpoVO> getList(Criteria criteria);
    //    게시글 추가
    public void insert(ExpoVO expoVO);
    //    게시글 추가(PK가져오기)
    public void insertSelectKey_expoNum(ExpoVO expoVO);
    //    게시글 상세보기(특정 게시글 정보)
    public ExpoVO read(Long expoNum);
    //    게시글 수정
    public int update(ExpoVO expoVO);
    //    게시글 삭제
    public int delete(Long expoNum);
    //    게시글 전체 개수
    public int getTotal(Criteria criteria);
}
