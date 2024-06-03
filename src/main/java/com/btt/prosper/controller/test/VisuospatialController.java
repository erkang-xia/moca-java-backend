package com.btt.prosper.controller.test;

import com.btt.prosper.common.dto.TrailMakingDTO;
import com.btt.prosper.common.result.Result;
import com.btt.prosper.service.impl.VisuospatialServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/visuospatial")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class VisuospatialController {
    private final VisuospatialServiceImpl visuospatialServiceImpl;

    public VisuospatialController(VisuospatialServiceImpl visuospatialServiceImpl) {
        this.visuospatialServiceImpl = visuospatialServiceImpl;
    }

//    @GetMapping("/dots")
//    public Result<List<Integer>> getDots(Integer userId){
//        List<Integer> dots = visuospatialService.getDots(userId);
//        return Result.success(dots);
//    }

    @PostMapping("/trailMaking")
    public Result saveTrailMaking(@RequestBody TrailMakingDTO trailMakingDTO){

        visuospatialServiceImpl.saveTrailMaking(trailMakingDTO);
        log.info("Saving trail making {}", trailMakingDTO);
        return Result.success();
    }


}
