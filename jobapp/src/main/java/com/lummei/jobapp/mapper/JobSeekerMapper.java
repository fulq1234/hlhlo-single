package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.JobSeeker;
import org.apache.ibatis.annotations.*;

@Mapper
public interface JobSeekerMapper {

//    @Insert(value = "insert into jobseeker (id,startWorkTime,marriage,degree,jobStatus,city) values(#{id},#{startWorkTime},#{marriage},#{degree},#{jobStatus},#{city})")
//    @Options(useGeneratedKeys = true)
//    int save(JobSeeker jobSeeker);

    @Update(value = "update jobseeker set startWorkTime = #{startWorkTime},marriage=#{marriage},degree=#{degree},jobStatus=#{jobStatus},city=#{city} where id = #{id}")
    int update(JobSeeker jobSeeker);

//    @Select(value = "select id, jobStatus, startWorkTime, marriage, degree, city from jobseeker where id = #{id}")
//    JobSeeker findOne(Long id);
}
