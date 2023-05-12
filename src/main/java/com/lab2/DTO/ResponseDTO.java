package com.lab2.DTO;

import java.util.List;

import lombok.Data;
import com.lab2.model.Point;

@Data
public class ResponseDTO {
    private boolean status;
    private String warning;
    private List<Point> points;
}
