package com.njucjz.demo.controller;


import com.njucjz.demo.data.Letter;
import com.njucjz.demo.form.GetLetterForm;
import com.njucjz.demo.form.WriteLetterForm;
import com.njucjz.demo.service.LetterService;
import com.njucjz.demo.vo.LetterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/letter")
public class LetterController {
    @Autowired
    LetterService letterService;

    //tip 为什么由Controller来处理逻辑打包呢？
    @PostMapping("/writeLetter")
    public boolean writeLetter(@RequestBody WriteLetterForm writeLetterForm){
        Letter letter = new Letter();
        BeanUtils.copyProperties(writeLetterForm,letter);
        return letterService.writeLetter(letter);
    }

    @PostMapping("/getLetter")
    public LetterVO getLetter(@RequestBody GetLetterForm getLetterForm){
        return (letterService.getLetter(getLetterForm.getUid(),getLetterForm.getMissTimes()));
    }
}
