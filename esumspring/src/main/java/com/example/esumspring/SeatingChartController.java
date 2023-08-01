package com.example.esumspring;

import com.example.esumspring.model.SeatingChart;
import com.example.esumspring.service.SeatingChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/1.0")
@CrossOrigin("http://localhost:8080")
public class SeatingChartController {

    @Autowired
    private final SeatingChartService seatingChartService;

    public SeatingChartController(SeatingChartService seatingChartService) {
        this.seatingChartService = seatingChartService;
    }

    @GetMapping("/seats")
    public List<SeatingChart> getAllSeats(){
        return seatingChartService.getAllSeats();
    }
}
