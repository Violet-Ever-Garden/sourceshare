package com.hw649.sources_share.controller;

import com.hw649.sources_share.pojo.User;
import com.hw649.sources_share.service.PassageServiceImpl;
import com.hw649.sources_share.service.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PassageServiceImpl passageService;

    @RequestMapping({"/","/index","/index.html"})
    public String toIndex(Model model){
        passageService.getPassageListByTime(model);
        return "index";
    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            //如果没有异常则正确登陆
            System.out.println("111");
            passageService.getPassageListByTime(model);
            return "index";
        } catch (UnknownAccountException ue) {
            model.addAttribute("msgu", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ie) {
            model.addAttribute("msgp", "密码错误");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noahtu(){
        return "未授权";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        return "login";
    }

    @RequestMapping("/show/{email}")
    @ResponseBody
    public User personalPage(@PathVariable("email") String email){
        return userService.selectUserByEmail(email);
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(String email, String name, String pwd,Model model) throws IOException {
        if(email=="" ) {
            model.addAttribute("msg","邮箱不可为空");
            return "register";
        }
        if(name=="" ) {
            model.addAttribute("msg","用户名不可为空");
            return "register";
        }
        if( pwd=="") {
            model.addAttribute("msg","密码不可为空");
            return "register";
        }
        if(userService.selectUserByEmail(email)!=null){
            model.addAttribute("msge","This email has been registered!");
            return "register";
        }
        if(userService.selectUserByName(name)!=null){
            model.addAttribute("msgn","This name has been registered!");
            return "register";
        }
        //以用户名作为密码盐
        String salt = name;
        //进行md5加密
        SimpleHash md5 = new SimpleHash("MD5", pwd, salt, 1024);
        //封装用户信息
        User user = userService.packege(email,name,md5.toString(),"",0);
        userService.insertUser(user);


        String path = System.getProperty("user.dir")+"/src/main/resources/static/avatar/";
        File dir = new File(path+name);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File source = new File(path+"avatar.jpg");
        File dest = new File(path+name+"/avatar.jpg");
        FileUtils.copyFile(source, dest);


        return "login";
    }





    @RequestMapping("/user")
    public String user(Model model){
        passageService.getUserShare(model);
        return "user";
    }

    @RequestMapping("/upload/avatar")
    public String avatarUpdate(Model model,@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            model.addAttribute("msg","文件为空");
        }
        else{
            Subject subject = SecurityUtils.getSubject();
            //封装用户数据
            String name = (String)subject.getSession().getAttribute("userName");
            String path = System.getProperty("user.dir")+"/src/main/resources/static/avatar/"+name;
            File serverFile = new File(path + "/avatar.jpg");
            File dir = new File(path);
            //System.out.println("开始上传");
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                file.transferTo(serverFile);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("msg","上传失败");
            }
        }
        passageService.getUserShare(model);
        return "user";
    }
}
