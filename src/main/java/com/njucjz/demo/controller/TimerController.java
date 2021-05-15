package com.njucjz.demo.controller;

import com.njucjz.demo.data.Timer;
import com.njucjz.demo.form.GetTimerByVersionForm;
import com.njucjz.demo.service.TimerService;
import com.njucjz.demo.vo.TimerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timer")
public class TimerController {
    @Autowired
    TimerService timerService;

    @PostMapping("/getTimer")
    public TimerVO getTimer(){
        return timerService.getTimer();
    }

    @PostMapping("/getTimerByVersion")
    public TimerVO getTimerByVersion(@RequestBody GetTimerByVersionForm form){
        return timerService.getTimerByVersion(form.getVersion());
    }
}
