package com.njucjz.demo.controller;

import com.njucjz.demo.data.Letter;
import com.njucjz.demo.form.WriteLetterForm;
import com.njucjz.demo.service.InfoService;
import com.njucjz.demo.vo.ConclusionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Info")
public class InfoController {
    @Autowired
    InfoService infoService;

    @PostMapping("/getConclusion")
    public ConclusionVO getConclusion(){
        return infoService.getConclusion();
    }
}
