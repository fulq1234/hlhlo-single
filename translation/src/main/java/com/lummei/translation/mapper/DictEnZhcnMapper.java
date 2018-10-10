package com.lummei.translation.mapper;

import com.lummei.translation.entity.DictEnZhcn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DictEnZhcnMapper {

    @Insert("insert into dict_en_zhcn(id,source,tran,example) values(#{id},#{source},#{tran},#{example})" )
    public int insert(DictEnZhcn one);

    @Select("select count(*) from dict_en_zhcn where source = #{source}")
    public int queryBySource(String source);


    @Select("select count(*) from dict_en_zhcn where tran = #{tran}")
    public int queryByTran(String tran);
}
