package com.koreait.yougn.mappers;

import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.FaqVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FaqMapperTest {

    @Autowired
    private FaqMapper mapper;

    @Test
    public void testGetList(){
        Criteria cri = new Criteria();
        cri.setPageNum(2);
        cri.setAmount(10);
        mapper.getList(cri).forEach(faqVO -> log.info(faqVO.toString()));
    }

    @Test
    public void testInsertSelectKey_num(){
        FaqVO faq = new FaqVO();
        faq.setTitle("문의글 작성 테스트 제목");
        faq.setContent("문의글 작성 테스트 내용");
        faq.setId("user01");
        mapper.insertSelectKey_num(faq);
    }

    @Test
    public void testRead(){
        log.info(mapper.read(1L).toString());
    }


    @Test
    public void testDelete(){
        if(mapper.read(241L) == null){
            log.info("***********NO SUCH BOARD***********");
        }else{
            log.info("DELETE COUNT : " + mapper.delete(241L));
        }
    }

    @Test
    public void testGetTotal(){
        Criteria criteria = new Criteria();
        mapper.getTotal(criteria);
    }
}
