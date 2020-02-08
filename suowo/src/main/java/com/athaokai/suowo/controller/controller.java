package com.athaokai.suowo.controller;

import com.athaokai.suowo.entity.mylist;
import com.athaokai.suowo.mapper.suoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class controller {
    @Autowired
    suoMapper suoMapperl;
    //页面跳转
    @ResponseBody
    @GetMapping("/{wo}")
    public String translation(String wo){
        mylist ml = suoMapperl.getSuo(wo);
        String str;
        if(ml==null){//如果数据库内不存在该网址，则插入
            str = "/hk/" + (new Integer(suoMapperl.getNumber())+1);
            suoMapperl.insert(wo,str);
        }else str = ml.getSuo();//若存在，返回suo；
        return str;
    }

    //suowo进行
    @GetMapping({"/hk/{suo}"})
    public String Translation(@PathVariable String suo){
        mylist mylist = suoMapperl.getWo("/hk/"+suo);
        if(mylist == null){
            return "suowo.html";//错误页面
        }
        String url =mylist.getWo();
        //redirect需配置thymeleaf
        return "redirect:https://"+url;
    }

}
