package com.hw649.sources_share.service;

import com.hw649.sources_share.pojo.Comment;

import java.util.List;

public interface CommentService {
    public void insertComment(Comment comment);
    public List<Comment> selectCommentByPassage(int passage);
}
