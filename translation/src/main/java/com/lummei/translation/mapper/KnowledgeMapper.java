package com.lummei.translation.mapper;


import com.lummei.translation.entity.Knowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KnowledgeMapper {

    /**
     * select title,content,instr(content,'<p>')
     * ,substring(content,1,instr(content,'<p>') -1),
     * replace(replace(replace(replace(replace(replace(substring(content,1,instr(content,'<p>') -1),'<h4>',''),'</h4>',''),'<br />',''),'<span>',''),'</span>',''),'&nbsp',''),
     * substring(content,instr(content,'<p>'))
     *  from knowledge_new where typename in (
     * 	select id from directory where fatherid=9 or fatherid in(select id from directory where fatherid=9)
     * );
     * @return
     */
    @Select("select id,title,content from knowledge_new where typename in (" +
            "select id from directory where fatherid=9 or fatherid in(select id from directory where fatherid=9)" +
            ")")
    List<Knowledge> select();

}
