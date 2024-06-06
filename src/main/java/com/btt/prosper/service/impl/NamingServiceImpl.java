package com.btt.prosper.service.impl;

import com.btt.prosper.mapper.NamingMapper;
import com.btt.prosper.mapper.PictureMapper;
import com.btt.prosper.mapper.VisuospatialMapper;
import com.btt.prosper.service.NamingService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.btt.prosper.common.constant.ExampleCountConstant.ANIMAL_COUNT;
import static com.btt.prosper.common.constant.S3BucketConstant.*;

@Service
public class NamingServiceImpl implements NamingService {


    private final VisuospatialMapper visuospatialMapper;
    private final PictureMapper pictureMapper;
    private final NamingMapper namingMapper;

    public NamingServiceImpl(VisuospatialMapper visuospatialMapper, PictureMapper pictureMapper, NamingMapper namingMapper) {
        this.visuospatialMapper = visuospatialMapper;
        this.pictureMapper = pictureMapper;
        this.namingMapper = namingMapper;
    }

    /**get animal
     *
     * @param testId
     * @return
     */
    //TODO: Transactional?
    public List<String> getAnimals(String testId) {
        List<String> keys = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        //TODO: 去除重复
        for(int i = 0; i < 3; i++){
            Integer animalId = (int) Math.round(Math.random() * ANIMAL_COUNT-1)+1;
            String key = pictureMapper.selectPictureKeyById(animalId, ANIMAL_CATEGORY);
            String answer = pictureMapper.selectPictureAnswerById(animalId, ANIMAL_CATEGORY);
            keys.add(key);
            answers.add(answer);
        }

        //TODO: think about update???
        namingMapper.updateAnswerByTestId(answers,testId);





        return keys;


    }
}
