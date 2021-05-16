package com.njucjz.demo.service;

import com.njucjz.demo.data.Letter;
import com.njucjz.demo.vo.LetterVO;

public interface LetterService {

    /*无关次数+UID，返回一封信*/
    LetterVO getLetter(Integer uid, Integer missTimes);

    /*保存一封信*/
    boolean writeLetter(Letter letter);
}
