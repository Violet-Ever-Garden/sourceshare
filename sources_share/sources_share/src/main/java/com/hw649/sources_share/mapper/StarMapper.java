package com.hw649.sources_share.mapper;


import com.hw649.sources_share.pojo.Star;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StarMapper {
    public void deleteStar(Star star);
    public int selectStarByPassage(int passage);
    public void insertStar(Star star);
    public Star selectStarByAuth(Star star);
}
