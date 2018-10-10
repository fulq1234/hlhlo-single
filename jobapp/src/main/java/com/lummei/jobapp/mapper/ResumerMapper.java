package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.Resume;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ResumerMapper {
    //@SelectKey(statement = "select max(id) id from resume",keyProperty = "id",before = false,resultType = Long.class)
    @Insert("insert into resume(id,userId,title,publishStatus,resumeType,info,deleteFlag,createTime,updateTime,refreshTime) values(#{id},#{userId},#{title},#{publishStatus},#{resumeType},#{info},#{deleteFlag},#{createTime},#{updateTime},#{refreshTime})")

    public int save(Resume job);

    @Select("select * from resume where userId = #{userId} limit 1")
    public Resume getResumeByUserId(Long userId);

    @Update(value = "update resume set info = #{info} where id = #{resumeId}")
    int updatePersonalInfo(@Param("resumeId")Long resumeId, @Param("info")String info);

}
