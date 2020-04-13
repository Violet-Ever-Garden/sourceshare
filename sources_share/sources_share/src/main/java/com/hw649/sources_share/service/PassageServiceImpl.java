package com.hw649.sources_share.service;

import com.hw649.sources_share.mapper.CommentMapper;
import com.hw649.sources_share.mapper.PassageMapper;
import com.hw649.sources_share.mapper.StarMapper;
import com.hw649.sources_share.pojo.Comment;
import com.hw649.sources_share.pojo.Passage;
import com.hw649.sources_share.pojo.Star;
import com.hw649.sources_share.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PassageServiceImpl implements PassageService{
    @Autowired
    PassageMapper passageMapper;
    @Autowired
    StarMapper starMapper;
    @Autowired
    CommentMapper commentMapper;

    public static Passage packege(String title,String introduction,String url,String pwd,String label){
        Timestamp timestamp = new java.sql.Timestamp ((new java.util.Date ()).getTime());
        Subject currentUser = SecurityUtils.getSubject();
        User loginUser = (User) currentUser.getSession().getAttribute("loginUser");
        return new Passage(title,introduction,url,pwd,timestamp,"checking",loginUser.getName(),0,label);
    }

    @Override
    public void insertPassage(Passage passage) {
         passageMapper.insertPassage(passage);
    }

    @Override
    public Passage selectPassageById(int id) {
         return passageMapper.selectPassageById(id);
    }

    @Override
    public List<Passage> selectPassageByTime(){return  passageMapper.selectPassageByTime(); }


    @Override
    public List<Passage> selectPassageByAuth(String auth){return passageMapper.selectPassageByAuth(auth); }

    @Override
    public List<Passage> selectPassageByTitle(String pattern){return passageMapper.selectPassageByTitle(pattern); }

    @Override
    public List<Passage> selectPassageByLabel(String label){ return passageMapper.selectPassageByLabel(label); }

    @Override
    public void addReadNum(int id){  passageMapper.addReadNum(id);}

    @Override
    public int selectReadNum(int id){ return passageMapper.selectReadNum(id); }


    public Model readPassage(Model model,int id) {
        Passage passage = passageMapper.selectPassageById(id);
        Subject currentUser = SecurityUtils.getSubject();
        User loginUser = (User) currentUser.getSession().getAttribute("loginUser");
        if (loginUser!=null) {
            Star star = new Star(id, loginUser.getName());
            if (starMapper.selectStarByAuth(star) == null) {
                model.addAttribute("isStar", 0);
                System.out.println("00");
            } else {
                model.addAttribute("isStar", 1);
                System.out.println(1);
            }
        }else{
            model.addAttribute("isStar",0);
            System.out.println("01");
        }
        //每次阅读使阅读量增加1
        passageMapper.addReadNum(id);
        model.addAttribute("id",id);
        model.addAttribute("readnum",passageMapper.selectReadNum(id));
        model.addAttribute("star",starMapper.selectStarByPassage(id));
        model.addAttribute("time",passage.getTime());
        model.addAttribute("title",passage.getTitle());
        model.addAttribute("url",passage.getUrl());
        model.addAttribute("label",passage.getLabel());
        model.addAttribute("pwd",passage.getPwd());
        model.addAttribute("text",passage.getIntroduction());
        model.addAttribute("auth",passage.getAuth());
        model.addAttribute("replies",commentMapper.selectCommentByPassage(id));
        return model;
    }

    public void addStar(int id){
        Subject currentUser = SecurityUtils.getSubject();
        User loginUser = (User) currentUser.getSession().getAttribute("loginUser");
        Star star = new Star(id,loginUser.getName());
        //添加收藏
        starMapper.insertStar(star);
    }

    public void deleteStar(int id){
        Subject currentUser = SecurityUtils.getSubject();
        User loginUser = (User) currentUser.getSession().getAttribute("loginUser");
        Star star = new Star(id,loginUser.getName());
        //添加收藏
        starMapper.deleteStar(star);
    }


    public Model getPassageListByTime(Model model){
        model.addAttribute("Passages",passageMapper.selectPassageByTime());
        return model;
    }

    public Model getPassageListByLabel(Model model,String label){
        model.addAttribute("Passages",passageMapper.selectPassageByLabel(label));
        return model;
    }

    public void reply(int id,String reply,String auth){
        Comment comment = new Comment(auth,id,reply);
        commentMapper.insertComment(comment);
    }


    public Model getLael(Model model){
        model.addAttribute("Picture",passageMapper.selectLabelNum("Picture"));
        model.addAttribute("Cartoon",passageMapper.selectLabelNum("Cartoon"));
        model.addAttribute("Game",passageMapper.selectLabelNum("Game"));
        model.addAttribute("Book",passageMapper.selectLabelNum("Book"));
        model.addAttribute("Other",passageMapper.selectLabelNum("Other"));
        model.addAttribute("Fanfiction",passageMapper.selectLabelNum("Fanfiction"));
        return model;
    }

    public Model getUserShare(Model model){
        Subject currentUser = SecurityUtils.getSubject();
        User loginUser = (User) currentUser.getSession().getAttribute("loginUser");
        model.addAttribute("Passages",passageMapper.selectPassageByAuth(loginUser.getName()));
        model.addAttribute("Stars",passageMapper.selectStarPassage(loginUser.getName()));
        model.addAttribute("Replies",commentMapper.selectCommentByAuth(loginUser.getName()));
        System.out.println(commentMapper.selectCommentByAuth(loginUser.getName()));
        return  model;
    }


    public Model searchPassageByStr(String str,Model model){
        String pattern = "%" + str + "%";
        model.addAttribute("Passages",passageMapper.selectPassageByTitle(pattern));
        return model;
    }
}
