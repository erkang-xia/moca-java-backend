package com.btt.prosper.service;

import com.btt.prosper.common.dto.TrailMakingDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

public interface VisuospatialService {

    /** 保存用户trail making的答案
     *
     * @param trailMakingDTO
     */
    void saveTrailMaking(TrailMakingDTO trailMakingDTO);

    /** 储存geometry id 并且向前端传递图片
     *
     * @param testId
     * @return
     */
    ResponseEntity<InputStreamResource> getGeometry(String testId);
}
