package com.btt.prosper.mapper;

import com.btt.prosper.entity.Visuospatial;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VisuospatialMapper {


    /** update visuospatial by TestId
     *
     * @param visuospatial
     */
    void updateVisuospatialByTestId(Visuospatial visuospatial);


    /** insert new visuospatial
     *
     * @param visuospatial
     */
    void insertVisuospatial(@Param("visuospatial") Visuospatial visuospatial);

    /**init database
     *
     * @param testId
     */
    @Insert("insert into visuospatial (test_id) values (#{testId})")
    void insertTestId(String testId);


}
