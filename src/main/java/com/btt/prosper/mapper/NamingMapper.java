package com.btt.prosper.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NamingMapper {


     void insertAnswerByTestId(List<String> answers, String testId);

     @Insert("insert into naming_animal (test_id) values (#{testid})")
     void insertTestId(String testId);

     @Update("update naming_animal set animal_example = #{answers,jdbcType=OTHER, typeHandler=com.btt.prosper.common.handler.JsonTypeHandler} where test_id = #{testId}")
     void updateAnswerByTestId(List<String> answers, String testId);
}
