package com.athk.lpl.mapper;

import com.athk.lpl.Entity.worldgame;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorldgameMapper {

    @Select("select * from worldgame")
    public List<Map<String,Object>> getAllworldgame();

    @Select("select * from worldgame where wname = #{wname}")
    public worldgame getworldgameByName(String wname);

    @Delete("delete from worldgame where wname = #{wname}")
    public worldgame deleteWorldGame (String wname);

    @Insert("insert worldgame(wname,wtime,wplace) values(#{wname},#{wtime},#{wplace})")
    public worldgame insertworldgame(worldgame worldgame);

    @Update("update worldgame set wplace = #{wplace} where wname = #{wname}")
    public worldgame updateWorldGame(String wname,String wplace);
}
