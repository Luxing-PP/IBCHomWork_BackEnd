package com.njucjz.demo.service;

import com.njucjz.demo.dao.LetterDao;
import com.njucjz.demo.dao.UserDao;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.vo.ConclusionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    LetterDao letterDao;
    @Autowired
    UserDao userDao;

    @Override
    public ConclusionVO getConclusion() {
        ConclusionVO conclusionVO =  new ConclusionVO();

        conclusionVO.setLivingTime(TimerInstance.getLivingTimeOfSecond());
        conclusionVO.setActiveUserAmount(userDao.getActiveUserAmount());
        conclusionVO.setLetterCount(letterDao.getLetterCountForAll());

        return conclusionVO;
    }
}
