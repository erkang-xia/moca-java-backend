package com.btt.prosper.service.impl;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.entity.Visuospatial;
import com.btt.prosper.mapper.VisuospatialMapper;
import com.btt.prosper.service.VisuospatialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.btt.prosper.common.constant.ExampleCountConstant.GEOMETRY_COUNT;

@Service
public class VisuospatialServiceImpl implements VisuospatialService {


    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private VisuospatialMapper visuospatialMapper;

    /**储存TrailMaking Test Result
     *
     * @param trailMakingDTO
     */
    public void saveTrailMaking(TrailMakingDTO trailMakingDTO) {

//            // Convert TrailMakingDTO to JSON string
//            String testId = objectMapper.writeValueAsString(trailMakingDTO.getTestId());
//            String dots = objectMapper.writeValueAsString(trailMakingDTO.getDots());
//            String lines = objectMapper.writeValueAsString(trailMakingDTO.getLines());
//            String clickSequence = objectMapper.writeValueAsString(trailMakingDTO.getClickSequence());

        // Save the JSON string to the database
//        Long userId = BaseContext.getCurrentId();
        Long userId = 1L;
        Visuospatial visuospatial = new Visuospatial();
        visuospatial.setUserId(userId);
        BeanUtils.copyProperties(trailMakingDTO, visuospatial);
        visuospatialMapper.insertVisuospatial(visuospatial);

    }

    /**储存geometryId 并向前端传递图片
     *
     * @param testId
     * @return
     */
    public ResponseEntity<InputStreamResource> getGeometry(String testId) {
        Integer geometryId = (int) Math.round(Math.random() * GEOMETRY_COUNT);
        String key = visuospatialMapper.selectPictureKeyById(geometryId, "2");
        Visuospatial visuospatial = Visuospatial.builder().visuoconstructionalExample(key).build();
        visuospatialMapper.updateByTestId(visuospatial);

        return null;
    }
}
