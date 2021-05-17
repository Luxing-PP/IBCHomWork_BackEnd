package com.njucjz.demo.service;

import com.njucjz.demo.dao.LetterDao;
import com.njucjz.demo.dao.UserLetterDao;
import com.njucjz.demo.data.Letter;
import com.njucjz.demo.data.UserLetter;
import com.njucjz.demo.util.MyUtil;
import com.njucjz.demo.vo.LetterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LetterServiceImpl implements LetterService {
    @Autowired
    LetterDao letterDao;
    @Autowired
    UserLetterDao userLetterDao;

    @Override
    public LetterVO getLetter(Integer uid, Integer missTimes) {
        Letter letter;

        if(MyUtil.isNeedRelativeLetter(missTimes)){
            letter = letterDao.getRelatedLetterByUid(uid);
        }else {
            letter = letterDao.getLetterByRandom();

            //tip 如果是所有者处理信件池
            if (letter.getUid()==uid){
                userLetterDao.deleteLetter(letter.getUid(),letter.getLid());
            }
        }

        if(letter==null){
            return null;
        }
        LetterVO letterVO = new LetterVO();
        BeanUtils.copyProperties(letter, letterVO);
        return letterVO;
    }

    @Override
    public boolean writeLetter(Letter letter) {
        boolean resultOfLetter;
        boolean resultOfUserLetter;
        try {
            //1.写入这封信件
            resultOfLetter = letterDao.writeLetter(letter);

            //2.存入对应user_letter 已双向绑定
            UserLetter userLetter = new UserLetter();
            userLetter.setUid(letter.getUid());
            userLetter.setLid(letter.getLid());

            resultOfUserLetter = userLetterDao.save(userLetter);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return resultOfUserLetter&&resultOfLetter;
    }
}
