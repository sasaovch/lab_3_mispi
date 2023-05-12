package com.lab3.DTO;

import java.util.List;

import lombok.Data;
import com.lab3.model.Point;

@Data
public class ResponseDTO {
    private boolean status;
    private String warning;
    private List<Point> points;
}
