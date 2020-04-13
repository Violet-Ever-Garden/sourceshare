package com.hw649.sources_share.mapper;

import com.hw649.sources_share.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    public void insertComment(Comment comment);
    public List<Comment> selectCommentByPassage(int passage);
    public List<Comment> selectCommentByAuth(String auth);
}
