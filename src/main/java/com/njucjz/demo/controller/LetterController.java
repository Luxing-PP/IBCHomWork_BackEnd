package com.njucjz.demo.controller;


import com.njucjz.demo.data.Letter;
import com.njucjz.demo.data.Response;
import com.njucjz.demo.form.GetLetterForm;
import com.njucjz.demo.form.GetResponseForm;
import com.njucjz.demo.form.WriteLetterForm;
import com.njucjz.demo.form.WriteResponseForm;
import com.njucjz.demo.service.LetterService;
import com.njucjz.demo.service.ResponseService;
import com.njucjz.demo.vo.LetterVO;
import com.njucjz.demo.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letter")
public class LetterController {
    @Autowired
    LetterService letterService;

    @Autowired
    ResponseService responseService;

    //check
    @PostMapping("/writeLetter")
    public boolean writeLetter(@RequestBody WriteLetterForm writeLetterForm){
        Letter letter = new Letter();
        BeanUtils.copyProperties(writeLetterForm,letter);
        return letterService.writeLetter(letter);
    }

    //check
    @PostMapping("/getLetter")
    public LetterVO getLetter(@RequestBody GetLetterForm getLetterForm){
        return (letterService.getLetter(getLetterForm.getUid(),getLetterForm.getMissTimes()));
    }

    //check
    @PostMapping("/writeResponse")
    public boolean writeResponse(@RequestBody WriteResponseForm writeResponseForm){
        Response response = new Response();
        BeanUtils.copyProperties(writeResponseForm,response);
        return responseService.writeResponse(response);
    }

    //check
    @PostMapping("/getResponse")
    public List<ResponseVO> getResponse(@RequestBody GetResponseForm form){
        return (responseService.getResponseByLid(form.getUid(),form.getLid()));
    }
}
