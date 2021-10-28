package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MarketMapperTest {

    @Autowired
    private MarketMapper marketMapper;

    @Test
    public void testGetItemList(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(10);
        marketMapper.getList(cri).forEach(marketMapper -> log.info(marketMapper.toString()));
    }

    @Test
    public void testInsert(){
        ItemVO itemVO = new ItemVO();

        itemVO.setItemhome("국내산1");
        itemVO.setItemdeliverprice("20001");
        itemVO.setItemcontent("테스트 새 글1 ");
        itemVO.setItemname("달달구리한 사과인가 테스트1");
        itemVO.setUserid("우정인01");
        itemVO.setItemprice("25000");
        itemVO.setItemtotalcount("500");
        marketMapper.insert(itemVO);
    }

  @Test
    public void testInsertSelectKey_itemnum(){
      ItemVO itemVO = new ItemVO();

      itemVO.setItemhome("국내산1");
      itemVO.setItemdeliverprice("20001");
      itemVO.setItemcontent("테스트 새 글1 ");
      itemVO.setItemname("달달구리한 사과인가 테스트1");
      itemVO.setUserid("우정인01");
      itemVO.setItemprice("25000");
      itemVO.setItemtotalcount("500");
      marketMapper.insertSelectKey_itemnum(itemVO);
    }


    @Test
    public void testUpdate(){
        if(marketMapper.read(98L) == null){
            log.info("***********NO SUCH BOARD***********");
        }else{
            ItemVO itemVO = new ItemVO();
            itemVO.setItemnum(98L);
            itemVO.setItemname("수정된 제목");
            itemVO.setItemcontent("수정된 글 내용");
            itemVO.setItemhome("국내 아님");
            itemVO.setItemdeliverprice("1000");
            itemVO.setItemprice("2500");
            log.info("UPDATE COUNT : " + marketMapper.update(itemVO));
        }
    }

    @Test
    public void testDelete(){
        if(marketMapper.read(98L) == null){
            log.info("***********NO SUCH BOARD***********");
        }else{
            log.info("DELETE COUNT : " + marketMapper.delete(98L));
        }
    }

}
