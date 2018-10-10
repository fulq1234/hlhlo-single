package com.lummei.jobapp.mapper;


import com.lummei.jobapp.entity.CareerObjective;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CareerObjectiveMapper {
    @Insert(value = "insert into careerobjective (id,resumeId,desiredType,function,industry,location,salary) " +
            "values(#{id},#{resumeId},#{desiredType},#{function},#{industry},#{location},#{salary})")
    @Options(useGeneratedKeys = true)
    int save(CareerObjective careerObjective);

}
