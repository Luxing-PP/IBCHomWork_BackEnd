package com.njucjz.demo;


import com.njucjz.demo.controller.InfoController;
import com.njucjz.demo.controller.LetterController;
import com.njucjz.demo.controller.UserController;
import com.njucjz.demo.dao.UserInfoDao;
import com.njucjz.demo.data.User;
import com.njucjz.demo.data.UserInfo;
import com.njucjz.demo.form.*;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.vo.ConclusionVO;
import com.njucjz.demo.vo.LetterVO;
import com.njucjz.demo.vo.UserInfoVO;
import com.njucjz.demo.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserControllerTest01 {
//    @Autowired
//    private UserController userController;
//    @Autowired
//    private LetterController letterController;
//    @Autowired
//    private InfoController infoController;
//    @Autowired
//    private UserInfoDao userInfoDao;

//    @Test
//    public void textContextLoads(){
//        UserForm userForm = new UserForm();
//        String username = "SpringTest"+(int)(Math.random()*500);
//        userForm.setUsername(username);
//        Assert.assertTrue(userController.register(userForm));
//
//        LoginForm loginForm = new LoginForm();
//        loginForm.setUsername(username);
//        UserVO userVO = userController.login(loginForm);
//        Assert.assertTrue(userVO.isNewDay());
//        Assert.assertTrue(username.equals(userVO.getUsername()));
//
//        //获取了UID
//        Integer uid = userVO.getUid();
//
//        WriteLetterForm writeLetterForm = new WriteLetterForm();
//        writeLetterForm.setUid(uid);
//        String content = username+":Letter";
//        writeLetterForm.setContent(content);
//        Assert.assertTrue(letterController.writeLetter(writeLetterForm));
//
//        //检查 userinfo+conclusion
//        ConclusionVO conclusionVO = infoController.getConclusion();
//        Assert.assertEquals(1,conclusionVO.getActiveUserAmount());
//        Assert.assertEquals(1,conclusionVO.getLetterCount());
//
//
//        //构建
//        GetInfoForm getInfoForm = new GetInfoForm();
//        getInfoForm.setUid(uid);
//        getInfoForm.setVersion(1);
//        //测试
//        UserInfoVO userInfoVO = userController.getInfo(getInfoForm);
//        Assert.assertTrue(1==userInfoVO.getLetterCount());
//        Assert.assertTrue(1==userInfoVO.getLoginDay());
//
//        //user Letter手动测试断点
//        int m = 0;
//
//        GetLetterForm getLetterForm = new GetLetterForm();
//        getLetterForm.setUid(uid);
//        getLetterForm.setMissTimes(1);
//        LetterVO letterVO = letterController.getLetter(getLetterForm);
//        Assert.assertTrue(content.equals(letterVO.getContent()));
//
//        //Reset测试
//        TimerInstance.getInstance().reset();
//        int n=0;
//    }
}
