package com.hw649.sources_share.service;

import com.hw649.sources_share.pojo.Passage;

import java.util.List;

public interface PassageService {
    public void insertPassage(Passage passage);
    public Passage selectPassageById(int id);
    public List<Passage> selectPassageByTime();
    public List<Passage> selectPassageByAuth(String auth);
    public List<Passage> selectPassageByTitle(String pattern);
    public List<Passage> selectPassageByLabel(String label);
    public int selectReadNum(int id);
    public void addReadNum(int id);
}