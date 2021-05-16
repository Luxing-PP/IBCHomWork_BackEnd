package com.njucjz.demo.service;

import com.njucjz.demo.dao.LetterDao;
import com.njucjz.demo.data.Letter;
import com.njucjz.demo.vo.LetterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LetterServiceImpl implements LetterService {
    @Autowired
    LetterDao letterDao;

    @Override
    public LetterVO getLetter(Integer uid, Integer missTimes) {
        //todo 根据missTimes修改返回值
        Letter letter = letterDao.getLetterByRandom();
        if(letter==null){
            return null;
        }
        LetterVO letterVO = new LetterVO();
        BeanUtils.copyProperties(letter, letterVO);
        return letterVO;
    }

    @Override
    //todo 要添加user_letter
    public boolean writeLetter(Letter letter) {
        boolean result = false;
        try {
            result = letterDao.writeLetter(letter);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
}
