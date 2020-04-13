package com.hw649.sources_share.service;

import com.hw649.sources_share.mapper.CommentMapper;
import com.hw649.sources_share.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void insertComment(Comment comment){ commentMapper.insertComment(comment);}
    @Override
    public List<Comment> selectCommentByPassage(int passage){
        return commentMapper.selectCommentByPassage(passage);
    }
}
