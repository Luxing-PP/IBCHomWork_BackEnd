package com.njucjz.demo.dao;

import com.njucjz.demo.data.UserLetter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLetterDao {
    boolean save(UserLetter userLetter);
    boolean deleteLetter(Integer uid, Integer lid);
}
