package com.athaokai.suowo.mapper;

import com.athaokai.suowo.entity.mylist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper
public interface suoMapper {
    @Select("select * from mylist where suo = #{suo}")
    public mylist getWo(String suo);

    @Select("select * from mylist where wo = #{wo}")
    public mylist getSuo(String wo);

    @Select("select count(*) from mylist")
    public String getNumber();

    @Insert("insert into mylist(wo,suo) value(#{wo},#{suo})")
    public int insert(String wo, String suo);
}
