package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.Education;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EducationMapper {
    @Insert(value = "insert into education (id,resumeId,startDate,endDate,school,major,degree,eduType,schoolExp)" +
            " values(#{id},#{resumeId},#{startDate},#{endDate},#{school},#{major},#{degree},#{eduType},#{schoolExp})")
    @Options(useGeneratedKeys = true)
    int save(Education education);


}
