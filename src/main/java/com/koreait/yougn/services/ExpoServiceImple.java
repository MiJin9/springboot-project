package com.koreait.yougn.services;

import com.koreait.yougn.beans.dao.ExpoDAO;
import com.koreait.yougn.beans.dao.ThumbDAO;
import com.koreait.yougn.beans.vo.Criteria;
import com.koreait.yougn.beans.vo.ExpoVO;
import com.koreait.yougn.beans.vo.ThumbVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ExpoServiceImple implements ExpoService{

    private final ExpoDAO expoDAO;
    private final ThumbDAO thumbDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(ExpoVO expoVO) {
        expoDAO.register(expoVO);/* 글 작성*/ /*여기서 가지고 오는거 아니야?*/
        if(expoVO.getAttachList() == null || expoVO.getAttachList().size() == 0){
            return; /* 파일이 없으면 */
        }
        log.info(expoVO.getExpoNum() + "");  /*어째서?*/
        /* 파일이 있으면*/
        expoVO.getAttachList().forEach(thumb -> {

            thumb.setExpoNum(expoVO.getExpoNum());
            log.info(thumb.getUuid());
            log.info(thumb.getExpoNum()+"");
            log.info(thumb.getFileName());
            log.info(thumb.getUploadPath());
            thumbDAO.insert(thumb);
        });
    }

    @Override
    public ExpoVO get(Long expoNum) {return expoDAO.get(expoNum); }

    @Override
    public boolean modify(ExpoVO expoVO) {return expoDAO.modify(expoVO); }

    @Override
    public boolean remove(Long expoNum) {return expoDAO.remove(expoNum); }

    @Override
    public List<ExpoVO> getList(Criteria criteria) {
        List<ExpoVO> expoVOList = expoDAO.getList(criteria);
        //빠른 for문
        for (ExpoVO expoVO : expoVOList){
            //반복돌려서 sysdate에서 시간만 잘려서 나오게
            expoVO.setExpoRegDate(expoVO.getExpoRegDate().split(" ")[0]);
            expoVO.setExpoUpdateDate(expoVO.getExpoUpdateDate().split(" ")[0]);
        }
        return expoVOList;
    }

    @Override
    public int getTotal(Criteria criteria) { return expoDAO.getTotal(criteria); }

    @Override
    public List<ThumbVO> getAttachList(Long expoNum) {
        return thumbDAO.findByNum(expoNum);
    }
}
