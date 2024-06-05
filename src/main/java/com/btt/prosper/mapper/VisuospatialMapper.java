package com.btt.prosper.mapper;

import com.btt.prosper.entity.Visuospatial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VisuospatialMapper {


    /**查询picture categoryId
     *
     * @param geometryId
     * @param category
     * @return
     */
    @Select("select `key` from picture where category = #{category} and category_id = #{geometryId}")
    String selectPictureKeyById(Integer geometryId, String category);


    /** update visuospatial by TestId
     *
     * @param visuospatial
     */
    void updateByTestId(Visuospatial visuospatial);


    /** insert new visuospatial
     *
     * @param visuospatial
     */
    void insertVisuospatial(@Param("visuospatial") Visuospatial visuospatial);
}
