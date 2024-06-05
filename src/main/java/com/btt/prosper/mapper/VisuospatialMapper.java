package com.btt.prosper.mapper;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.entity.Visuospatial;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VisuospatialMapper {



    @Select("select `key` from picture where category = #{category} and category_id = #{geometryId}")
    String selectById(Integer geometryId, String category);


    void updateByTestId(Visuospatial visuospatial);


    void insertByTrailMakingDTO(Long userId, @Param("trailMaking") TrailMakingDTO trailMakingDTO);
}
