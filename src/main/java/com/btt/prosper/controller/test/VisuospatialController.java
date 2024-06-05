package com.btt.prosper.controller.test;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.common.result.Result;
import com.btt.prosper.service.VisuospatialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/visuospatial")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class VisuospatialController {

    @Autowired
    VisuospatialService visuospatialService;

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
    public ResponseEntity<InputStreamResource> getGeometry(@PathVariable String testId){
        log.info("Getting geometry {}", testId);
        return visuospatialService.getGeometry(testId);

    }




}
