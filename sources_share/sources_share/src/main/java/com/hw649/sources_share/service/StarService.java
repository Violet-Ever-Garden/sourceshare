package com.hw649.sources_share.service;

import com.hw649.sources_share.pojo.Star;

public interface StarService {
    public int selectStarByPassage(int passage);
    public void insertStar(Star star);
}
