package com.btt.prosper.service;

import com.btt.prosper.common.result.Result;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NamingService {

    /** get animal
     *
     * @param testId
     * @return
     */
    List<String> getAnimals(String testId);
}
