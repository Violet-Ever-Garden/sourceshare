package com.hw649.sources_share.mapper;

import com.hw649.sources_share.pojo.Passage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PassageMapper {
    public Passage selectPassageById(int id);
    public void insertPassage(Passage passage);
    public List<Passage> selectPassageByTime();
    public List<Passage> selectPassageByPraise();
    public List<Passage> selectPassageByAuth(String auth);
    public List<Passage> selectPassageByTitle(String pattern);
    public List<Passage> selectPassageByLabel(String label);
    public int selectReadNum(int id);
    public void addReadNum(int id);
    public int selectLabelNum(String label);
    public List<Passage> selectStarPassage(String auth);
}
