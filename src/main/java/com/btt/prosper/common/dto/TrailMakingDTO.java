package com.btt.prosper.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class TrailMakingDTO implements Serializable {
    private List<Dot> dots;
    private List<Line> lines;
    private List<Integer> clickSequence;

    @Data
    public static class Dot {
        private int id;
        private String label;
        private int x;
        private int y;
    }

    @Data
    public static class Line {
        private int start;
        private int end;
    }
}
