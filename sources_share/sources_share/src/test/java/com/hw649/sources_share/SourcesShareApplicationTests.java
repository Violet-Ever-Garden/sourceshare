package com.hw649.sources_share;

import com.hw649.sources_share.mapper.CommentMapper;
import com.hw649.sources_share.pojo.Comment;
import com.hw649.sources_share.pojo.Passage;
import com.hw649.sources_share.service.PassageServiceImpl;
import com.hw649.sources_share.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@SpringBootTest
class SourcesShareApplicationTests {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    PassageServiceImpl passageService;

    @Autowired
    CommentMapper commentMapper;
    @Test
    void contextLoads() {
        System.out.println(userServiceImpl.selectUserByName("hk").getEmail());
    }


    //@Test
    void insertPassage(){
        Timestamp timestamp = new java.sql.Timestamp ((new java.util.Date ()).getTime());
        Passage passage = new Passage("美少女万华镜2","勿忘我与永远的少女",
                "hk.com","1234", timestamp,"checking","239@qq.com",0,"");
        passageService.insertPassage(passage);
    }

    //@Test
    void selectComment(){
        commentMapper.insertComment(new Comment("hk1",9,"123"));
        System.out.println(commentMapper.selectCommentByPassage(9));
    }
    @Test
    void fileTest() throws IOException {
        String path = "/sourceshare/data/avatar/";
        File dir = new File(System.getProperty("user.dir")+"\\src\\resources\\avatar");
        System.out.println(dir.exists());
        dir.mkdir();

    }
}
