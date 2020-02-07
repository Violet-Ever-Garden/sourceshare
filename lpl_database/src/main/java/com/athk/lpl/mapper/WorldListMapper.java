package com.athk.lpl.mapper;

import com.athk.lpl.Entity.worldlist;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorldListMapper {
    @Select("select * from worldlist")
    public List<Map<String,Object>> getAlllist();

    @Select("select * from worldlist where wname = #{wname}")
    public List<Map<String,Object>> getworldlistBywName(String wname);

    @Select("select * from worldlist where tname = #{tname}")
    public List<Map<String,Object>> getworldlistBytName(String tname);

    @Delete("delete from worldlist where wname = #{wname} and tname = #{tname}")
    public worldlist deleteWorldlist (String wname,String tname);

    @Insert("insert worldlist(tname,wname,ranking) values(#{tname},#{wname},#{ranking})")
    public worldlist insertworldlist(worldlist worldlist);

    @Update("update worldlist set wplace = #{wplace} where  tname= #{tname} and wname = #{wname}")
    public worldlist updateWorldlist(String tname,String wname,String wplace);

}
