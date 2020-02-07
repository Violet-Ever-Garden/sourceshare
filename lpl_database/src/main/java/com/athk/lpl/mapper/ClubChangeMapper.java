package com.athk.lpl.mapper;

import com.athk.lpl.Entity.club_change;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClubChangeMapper {
    @Select("select * from club_change ")
    public List<Map<String,Object>> getAllChange();

    @Select("select * from club_change where p_name = #{p_name}")
    public club_change getClubChangeByp_name(String p_name);

    @Select("select * from club_change where tname = #{tname}")
    public club_change getClubChangeBytname(String tname);

    @Insert("insert into club_change(p_name,tname,c_time)" +
            "values (#{p_name},#{tname},#{c_time})")
    public int insertclub_change(club_change club_change);

}
