package com.hw649.sources_share.controller;

import com.hw649.sources_share.pojo.Passage;
import com.hw649.sources_share.service.CommentServiceImpl;
import com.hw649.sources_share.service.PassageServiceImpl;
import com.hw649.sources_share.service.StarServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PassageController {
    @Autowired
    PassageServiceImpl passageService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    StarServiceImpl starService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        //System.out.println(session.getAttribute("userName"));
        return "createPassage";
    }

    @RequestMapping("/create")
    public String create(String title,String introduction,String url,String pwd,String label,Model model){
        if(title==null || introduction==null || url==null ||
            pwd == null || label==null ){
            model.addAttribute("msg","请将表格填满");
            return "createPassage";
        }
        Passage passage = PassageServiceImpl.packege(title,introduction,url,pwd,label);
        passageService.insertPassage(passage);
        passageService.getPassageListByTime(model);
        return "index";
    }

    @RequestMapping("/read/{passageId}")
    public String read(Model model, @PathVariable int passageId){
        passageService.readPassage(model,passageId);
        return "read";
    }

    @RequestMapping("/label/{label}")
    public String selectLabel(Model model,@PathVariable String label){
        passageService.getPassageListByLabel(model,label);
        return "list";
    }


    @RequestMapping("/label")
    public String getLabel(Model model){
        passageService.getLael(model);
        return "label";
    }

    @RequestMapping("/time")
    public String selectTime(Model model){
        passageService.getPassageListByTime(model);
        return "list";
    }

    @GetMapping("/404")
    public Object customNotFound(){
        return "error404";
    }

    @RequestMapping("/reply/{passageId}")
    public String reply(Model model,@PathVariable int passageId,String reply ){
        if(reply==null){
            model.addAttribute("msgr","回复不可为空");
        }else {
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            String auth = (String) session.getAttribute("userName");
            passageService.reply(passageId, reply, auth);
        }
        passageService.readPassage(model,passageId);
        return "read";
    }

    @RequestMapping("/star/{passageId}")
    public String star(Model model, @PathVariable int passageId){
        passageService.addStar(passageId);
        passageService.readPassage(model,passageId);
        System.out.println("star");
        return "read";
    }

    @RequestMapping("/deleteStar/{passageId}")
    public String deleteStar(Model model, @PathVariable int passageId){
        passageService.deleteStar(passageId);
        passageService.readPassage(model,passageId);
        return "read";
    }

    @RequestMapping("/search")
    public String search(String str,Model model){
        //System.out.println(str);
        passageService.searchPassageByStr(str,model);
        return "list";
    }
}
