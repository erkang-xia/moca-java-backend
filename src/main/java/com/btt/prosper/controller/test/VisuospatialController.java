package com.btt.prosper.controller.test;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.common.result.Result;
import com.btt.prosper.service.S3Service;
import com.btt.prosper.service.VisuospatialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.btt.prosper.common.constant.S3BucketConstant.BUCKET_NAME;

@RestController
@RequestMapping("/test/visuospatial")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class VisuospatialController {

    @Autowired
    VisuospatialService visuospatialService;
    @Autowired
    private S3Service s3Service;

//    @GetMapping("/dots")
//    public Result<List<Integer>> getDots(Integer userId){
//        List<Integer> dots = visuospatialService.getDots(userId);
//        return Result.success(dots);
//    }

    @PostMapping("/trailMaking")
    public Result saveTrailMaking(@RequestBody TrailMakingDTO trailMakingDTO){

        visuospatialService.saveTrailMaking(trailMakingDTO);
        log.info("Saving trail making {}", trailMakingDTO);
        return Result.success();
    }

    @GetMapping("/geometry/{testId}")
    public ResponseEntity<byte[]> getGeometry(@PathVariable String testId){
        log.info("Getting geometry {}", testId);
        return visuospatialService.getGeometry(testId);

    }

    @PostMapping("/geometry/{testId}")
    public Result SaveGeometry(@PathVariable String testId, @RequestParam("file") MultipartFile file){
        String key = file.getOriginalFilename();
        log.info("Saving geometry {}", testId);
        try {
            s3Service.uploadFile(BUCKET_NAME, key, file.getBytes());
            visuospatialService.saveGeometry(key,testId);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success();
    }

    @PostMapping("/clock/{testId}")
    public Result SaveClock(@PathVariable String testId, @RequestParam("file") MultipartFile file){
        String key = file.getOriginalFilename();
        log.info("Saving clock {}", testId);
        try {
            s3Service.uploadFile(BUCKET_NAME, key, file.getBytes());
            visuospatialService.saveClock(key,testId);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success();
    }

    @PostMapping("/clock_expression/{testId}")
    public Result SaveClockExpression(@PathVariable String testId, @RequestBody String clockExpression){
        log.info("Saving clock_expression {}", testId);
        visuospatialService.saveClockExpression(clockExpression,testId);

        return Result.success();
    }




}
