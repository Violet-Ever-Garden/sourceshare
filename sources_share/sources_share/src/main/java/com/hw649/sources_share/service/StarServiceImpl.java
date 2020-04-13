package com.hw649.sources_share.service;

import com.hw649.sources_share.mapper.StarMapper;
import com.hw649.sources_share.pojo.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarServiceImpl implements StarService{
    @Autowired
    StarMapper starMapper;

    @Override
    public int selectStarByPassage(int passage){ return starMapper.selectStarByPassage(passage);}

    @Override
    public void insertStar(Star star){ starMapper.insertStar(star);}
}
