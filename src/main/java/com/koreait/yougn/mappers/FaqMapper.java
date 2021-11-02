package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.FaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {
    //    문의글 목록
    public List<FaqVO> getList(Criteria criteria);

    //    문의글 추가(PK가져오기)
    public void insertSelectKey_num(FaqVO faq);

    //    문의글 상세보기(특정 게시글 정보)
    public FaqVO read(Long num);

    //    문의글 삭제
    public int delete(Long num);

    //    문의글 전체 개수
    public int getTotal(Criteria criteria);

    //내가 쓴 문의글 목록
    public List<FaqVO> getListId(Criteria criteria, String id);

    //내가 쓴 문의글 전체 개수
    public int getTotalId(Criteria criteria, String id);

    //댓글달기
    public int insertReply(FaqVO faq);

    //댓글보기
    public FaqVO readReply(Long num);

//    //댓글수정
//    public int modifyReply(FaqVO faq);
}
