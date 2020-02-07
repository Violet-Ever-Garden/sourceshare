package com.athk.lpl.mapper;

import com.athk.lpl.Entity.player;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlayerMapper {

    @Select("select * from player")
    public List<Map<String,Object>> getAllPlayer();

    @Select("select * from player where p_name = #{name}")
    public player getPlayerByName(String name);

    @Delete("delete from player where p_name = #{name}")
    public int deletePlayerByName(String name);

    @Insert("insert into player(p_name,p_age,place,p_kill,p_death,p_assist,team)" +
            "values (#{p_name},#{p_age},#{place},#{p_kill},#{p_death},#{p_assist},#{team})")
    public int insertPlayer(player player);

    @Update("update player set place = #{place} where p_name = #{p_name}")
    public int updatePlayer(String place,String p_name);
}
