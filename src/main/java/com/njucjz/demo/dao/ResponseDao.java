package com.njucjz.demo.dao;

import com.njucjz.demo.data.Response;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResponseDao {
    boolean save(Response response);
    List<Response> getResponseByLid(Integer lid);
}
