package com.athk.lpl.mapper;


import com.athk.lpl.Entity.match;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MatchMapper {
    @Select("select * from matchs")
    public List<Map<String,Object>> getAllMatch();

    @Select("select * from matchs where mID = #{mID}")
    public match getmatchByName(String mID);

    @Delete("delete from matchs where mID = #{mID}")
    public int deletematchByName(String mID);

    @Insert("insert into matchs(mID,winner,loser,mvp)" +
            "values (#{mID},#{winner},#{loser},#{mvp},#{m_time})")
    public int insertmatch(match match);

    @Update("update matchs set mvp = #{mvp} where mID = #{mID}")
    public int updatematch(String mvp,String mID);
}
