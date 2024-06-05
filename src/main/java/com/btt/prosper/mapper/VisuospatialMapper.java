package com.btt.prosper.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisuospatialMapper {

    //TODO: implement to avoid duplicates
    @Insert("insert into visuospatial (test_id, user_id, dots, `lines`, click_sequence) values ( #{userId}, #{userId},#{dots}, #{lines}, #{clickSequence})")
    void insertByUserId(Long userId, String dots, String lines, String clickSequence);
}
