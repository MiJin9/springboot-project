package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.BoardsVO;
import com.koreait.yougn.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class BoardsMapperTest {

    @Autowired
    private BoardsMapper mapper;

    @Test
    public void testGetList(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(10);
        cri.setBoardType(1);
        mapper.getList(cri).forEach(boards -> log.info(mapper.toString()));
    }

    @Test
    public void testInsert(){
        BoardsVO boards = new BoardsVO();

        boards.setTitle("공지 사항 매퍼 테스트");
        boards.setContent("새로 작성한 글 내용");
        boards.setId("장태순");
        mapper.insert(boards);
    }

    @Test
    public void testInsertSelectKey_bno(){
        BoardsVO boards = new BoardsVO();
        boards.setTitle("공지 사항 매퍼 테스트");
        boards.setContent("새로 작성한 글 내용");
        boards.setId("장태순");
        boards.setType(0);
        mapper.insertSelectKey_bno(boards);
    }

    @Test
    public void testRead(){
        mapper.plusOne(4L);
        log.info(mapper.read(4L).toString());
    }

    @Test
    public void testUpdate(){
        if(mapper.read(40L) == null){
            log.info("***********NO SUCH BOARD***********");
        }else{
            BoardsVO boards = new BoardsVO();
            boards.setBno(40L);
            boards.setTitle("수정된 글 제목");
            boards.setContent("수정된 글 내용");
            log.info("UPDATE COUNT : " + mapper.update(boards));
        }
    }

    @Test
    public void testDelete(){
        if(mapper.read(4L) == null){
            log.info("***********NO SUCH BOARD***********");
        }else{
            log.info("DELETE COUNT : " + mapper.delete(4L));
        }
    }

    @Test
    public void testGetTotal(){
        Criteria cri = new Criteria();
        cri.setType("T");
        cri.setKeyword("업로드");
        cri.setBoardType(4);
        mapper.getTotal(cri);
    }
    
}
