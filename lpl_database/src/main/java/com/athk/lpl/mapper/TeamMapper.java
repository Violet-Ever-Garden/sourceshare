package com.athk.lpl.mapper;


import com.athk.lpl.Entity.team;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeamMapper {
    @Select("select * from team")
    public List<Map<String,Object>> getallteam();

    @Select("select * from team where tname = #{tname}")
    public team getteamByName(String tname);

    @Delete("delete from team where tname = #{tname}")
    public int deleteteamByName(String tname);

    @Insert("insert into team(tname,location,win,lose)" +
            "values (#{tname},#{location},#{win},#{lose})")
    public int insertteam(team team);

    @Update("update team set location = #{location} where tname = #{tname}")
    public int updateteam(String location,String tname);
}
