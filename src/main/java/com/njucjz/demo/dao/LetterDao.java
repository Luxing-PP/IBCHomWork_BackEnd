package com.njucjz.demo.dao;

import com.njucjz.demo.data.Letter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LetterDao {
    boolean writeLetter(Letter letter);

    /*获取某用户写过的信数*/
    int getLetterCountByUid(Integer uid);

    /*tip 随机获取，据网上称可以优化*/
    Letter getLetterByRandom();

    /*获取后会删除 */
    Letter getRelatedLetterByUid(Integer uid);
}
