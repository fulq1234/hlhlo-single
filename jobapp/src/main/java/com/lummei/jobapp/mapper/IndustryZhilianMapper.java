package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.IndustryZhilian;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface IndustryZhilianMapper {

    @Select("select * from industryZhilian where zlkey = #{zlkey}")
    public IndustryZhilian queryByZLKey(String zlKey);

    @Insert("insert into industryZhilian(`key`,`value`,zlkey) values(#{key},#{value},#{zlkey})")
    public void insert(IndustryZhilian bean);
}
