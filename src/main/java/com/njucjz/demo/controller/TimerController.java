package com.njucjz.demo.controller;

import com.njucjz.demo.data.Timer;
import com.njucjz.demo.form.GetTimerByVersionForm;
import com.njucjz.demo.service.TimerService;
import com.njucjz.demo.vo.TimerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timer")
public class TimerController {
    @Autowired
    TimerService timerService;

    @GetMapping("/getTimer")
    public TimerVO getTimer(){
        return timerService.getTimer();
    }

    @PostMapping("/getTimerByVersion")
    //Check
    public TimerVO getTimerByVersion(@RequestBody GetTimerByVersionForm form){
        return timerService.getTimerByVersion(form.getVersion());
    }
}
