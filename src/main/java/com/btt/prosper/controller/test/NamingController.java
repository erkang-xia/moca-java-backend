package com.btt.prosper.controller.test;

import com.btt.prosper.common.result.Result;
import com.btt.prosper.service.NamingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/naming")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class NamingController {

    @Autowired
    NamingService namingService;

    @GetMapping("/animals/{testId}")
    public Result<List<String>> getAnimals(@PathVariable String testId){
        log.info("Getting animal {}", testId);
        return Result.success(namingService.getAnimals(testId));


    }

}
