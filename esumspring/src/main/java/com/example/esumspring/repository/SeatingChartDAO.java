package com.example.esumspring.repository;

import com.example.esumspring.model.SeatingChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatingChartDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public SeatingChartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SeatingChart> getAllSeats(){
        String sql = "SELECT * FROM seatingchart";
        List<SeatingChart> seatsList = jdbcTemplate.query(sql, (result, rowNum) -> {
            SeatingChart seat = new SeatingChart();
            seat.setFLOOR_SEAT_SEQ(result.getInt("FLOOR_SEAT_SEQ"));
            seat.setFLOOR_NO(result.getInt("FLOOR_NO"));
            seat.setSEAT_NO(result.getInt("SEAT_NO"));
            return seat;
        });
        return seatsList;
    }
}
