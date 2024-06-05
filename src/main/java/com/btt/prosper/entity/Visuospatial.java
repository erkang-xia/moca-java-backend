package com.btt.prosper.entity;


import com.btt.prosper.common.dto.TrailMakingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visuospatial {
    private String testId;
    private Long userId;

    private List<TrailMakingDTO.Dot> dots;
    private List<TrailMakingDTO.Line> lines;
    private List<Integer> clickSequence;

    private String visuoconstructionalExample;
    private String visuoconstructionalAnswer;
    private String visuoconstructionalClock;
    private String clockExpression;
    private Integer score;
    private String completion_time;
    private DateTime completed_on;
}
