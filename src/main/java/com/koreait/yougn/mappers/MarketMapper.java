package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ItemVO;
import com.koreait.yougn.beans.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper {
    //    게시글 목록
    public List<ItemVO> getList(Criteria criteria);
    //    게시글 추가
    public void insert(ItemVO itemVO);
    //    게시글 추가(PK가져오기)
    public void insertSelectKey_itemnum(ItemVO itemVO);
    //    게시글 상세보기(특정 게시글 정보)
    public ItemVO read(Long itemnum);
    //    게시글 수정
    public int update(ItemVO itemVO);
    //    게시글 삭제
    public int delete(Long itemnum);
    //    게시글 전체 개수
    public int getTotal(Criteria criteria);

    /* 오더 */
    //전체 주문 리스트
    public int orderGetTotal(Criteria criteria);

    // 페이지별 주문 리스트
    public List<OrderVO> orderGetList(Criteria criteria);

    public void orderInsert(OrderVO orderVO);


}
