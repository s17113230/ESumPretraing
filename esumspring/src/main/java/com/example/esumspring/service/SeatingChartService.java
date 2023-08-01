package com.example.esumspring.service;

import com.example.esumspring.model.SeatingChart;
import com.example.esumspring.repository.SeatingChartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingChartService {

    @Autowired
    private final SeatingChartDAO seatingChartDAO;

    public SeatingChartService(SeatingChartDAO seatingChartDAO) {
        this.seatingChartDAO = seatingChartDAO;
    }

    public List<SeatingChart> getAllSeats(){
        return seatingChartDAO.getAllSeats();
    }
}
