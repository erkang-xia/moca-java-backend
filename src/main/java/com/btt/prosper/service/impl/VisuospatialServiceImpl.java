package com.btt.prosper.service.impl;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.entity.Visuospatial;
import com.btt.prosper.mapper.PictureMapper;
import com.btt.prosper.mapper.VisuospatialMapper;
import com.btt.prosper.service.S3Service;
import com.btt.prosper.service.VisuospatialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.btt.prosper.common.constant.ExampleCountConstant.GEOMETRY_COUNT;
import static com.btt.prosper.common.constant.S3BucketConstant.*;

@Service
@Slf4j
public class VisuospatialServiceImpl implements VisuospatialService {


    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private VisuospatialMapper visuospatialMapper;
    @Autowired
    private S3Service s3Service;
    @Autowired
    private PictureMapper pictureMapper;

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
        //TODO: put back interceptor, and use real id
        Long userId = 1L;
        Visuospatial visuospatial = new Visuospatial();
        visuospatial.setUserId(userId);
        BeanUtils.copyProperties(trailMakingDTO, visuospatial);
//        visuospatialMapper.insertVisuospatial(visuospatial);
        visuospatialMapper.updateVisuospatialByTestId(visuospatial);

    }

    /**
     * 储存geometryId 并向前端传递图片
     *
     * @param testId
     * @return
     */
    public ResponseEntity<byte[]> getGeometry(String testId) {

        Integer geometryId = (int) Math.round(Math.random() * GEOMETRY_COUNT-1)+1;
        String key = pictureMapper.selectPictureKeyById(geometryId, GEOMETRY_CATEGORY);
        Visuospatial visuospatial = Visuospatial.builder().visuoconstructionalExample(key).testId(testId).build();
        visuospatialMapper.updateVisuospatialByTestId(visuospatial);

        byte[] res = s3Service.downloadFile(BUCKET_NAME, key);
        log.info("Sending image with key {} and content type {}", key, MediaType.IMAGE_JPEG_VALUE);

        return ResponseEntity.ok().contentType(MediaType.valueOf("image/jpeg")).body(res);
    }

    /**
     * 储存user geometry answer key
     *
     * @param key
     * @param testId
     */
    public void saveGeometry(String key, String testId) {

        Visuospatial visuospatial = Visuospatial.builder().visuoconstructionalAnswer(key).testId(testId).build();
        visuospatialMapper.updateVisuospatialByTestId(visuospatial);

    }

    /**
     * 储存 user clock answer
     *
     * @param key
     * @param testId
     */
    public void saveClock(String key, String testId) {
        Visuospatial visuospatial = Visuospatial.builder().visuoconstructionalClock(key).testId(testId).build();
        visuospatialMapper.updateVisuospatialByTestId(visuospatial);

    }

    /**
     * 储存 user clock expression
     *
     * @param clockExpression
     * @param testId
     */
    public void saveClockExpression(String clockExpression, String testId) {
        Visuospatial visuospatial = Visuospatial.builder().clockExpression(clockExpression).testId(testId).build();
        visuospatialMapper.updateVisuospatialByTestId(visuospatial);

    }
}
