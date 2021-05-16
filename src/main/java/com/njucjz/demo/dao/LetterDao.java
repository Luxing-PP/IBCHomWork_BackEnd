package com.njucjz.demo.dao;

import com.njucjz.demo.data.Letter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LetterDao {
    boolean writeLetter(Letter letter);

    /*Tip 随机获取，据网上称可以优化 草 有Bug*/
    Letter getLetterByRandom();

    /*Tip 获取后会删除*/
    Letter getRelatedLetterByUid(Integer uid);
}
