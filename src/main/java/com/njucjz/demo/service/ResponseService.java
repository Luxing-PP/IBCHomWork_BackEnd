package com.njucjz.demo.service;

import com.njucjz.demo.data.Response;
import com.njucjz.demo.vo.ResponseVO;

import java.util.List;

public interface ResponseService {
    /*保存评论*/
    boolean writeResponse(Response response);
    /*根据LID获取评论 根据UID更新信件池*/
    List<ResponseVO> getResponseByLid(Integer uid,Integer lid);
}
