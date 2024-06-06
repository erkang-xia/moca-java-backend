package com.btt.prosper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PictureMapper {

    /**查询picture categoryId
     *
     * @param categoryId
     * @param category
     * @return
     */
    @Select("select `key` from picture where category = #{category} and category_id = #{categoryId}")
    String selectPictureKeyById(Integer categoryId, String category);

    /**查询picture answer
     *
     * @param categoryId
     * @param category
     * @return
     */
    @Select("select answer from picture where category = #{category} and category_id = #{categoryId}")
    String selectPictureAnswerById(Integer categoryId, String category);
}
