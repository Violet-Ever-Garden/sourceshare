package com.athk.lpl.mapper;

import com.athk.lpl.Entity.coach;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CoachMapper {
    @Select("select * from coach")
    public List<Map<String,Object>> getAllcoach();

    @Select("select * from coach where cname = #{cname}")
    public coach getcoachByName(String cname);

    @Delete("delete from coach where cname = #{cname}")
    public int deletecoachByName(String cname);

    @Insert("insert into coach(cname,team,nationality,cage)" +
            "values (#{cname},#{team},#{nationality},#{cage})")
    public int insertcoach(coach coach);

    @Update("update coach set team = #{team} where cname = #{cname}")
    public int updatecoach(String team,String cname);
}
