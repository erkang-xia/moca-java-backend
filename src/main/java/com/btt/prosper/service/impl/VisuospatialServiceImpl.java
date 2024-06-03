package com.btt.prosper.service.impl;

import com.btt.prosper.common.context.BaseContext;
import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.mapper.VisuospatialMapper;
import com.btt.prosper.service.VisuospatialService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try {

            // Convert TrailMakingDTO to JSON string
            String dots = objectMapper.writeValueAsString(trailMakingDTO.getDots());
            String lines = objectMapper.writeValueAsString(trailMakingDTO.getLines());
            String clickSequence = objectMapper.writeValueAsString(trailMakingDTO.getClickSequence());

            // Save the JSON string to the database
            Long userId = BaseContext.getCurrentId();
            visuospatialMapper.insertByUserId(userId,dots,lines,clickSequence);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to save trail making", e);
        }

    }
}
