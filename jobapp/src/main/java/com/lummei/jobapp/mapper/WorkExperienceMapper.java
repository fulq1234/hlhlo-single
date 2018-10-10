package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.WorkExperience;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkExperienceMapper {
    @Insert(value = "insert into workexperience (id,positionType,resumeId,startDate,endDate,companyName,department,position,salary,leaveReason,jobExp,industry) " +
            "values(#{id},'',#{resumeId},#{startDate},#{endDate},#{companyName},#{department},#{position},#{salary},#{leaveReason},#{jobExp},#{industry})")
    @Options(useGeneratedKeys = true)
    int save(WorkExperience workExperience);


}
