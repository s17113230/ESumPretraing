package com.example.esumspring.repository;

import com.example.esumspring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees(){
        String sql = "SELECT * FROM employee";
        List<Employee> employeesList = jdbcTemplate.query(sql, (result, rowNum) -> {
            Employee employee = new Employee();
            employee.setEMP_ID(result.getInt("EMP_ID"));
            employee.setNAME(result.getString("NAME"));
            employee.setEMAIL(result.getString("EMAIL"));
            employee.setFLOOR_SEAT_SEQ(result.getInt("FLOOR_SEAT_SEQ"));
            return employee;
        });
        return employeesList;
    }

    @Transactional
    public List<Employee> updateSeatSeqByEmpId(Integer empId, Integer seatSeq){
        String sql = "UPDATE employee SET FLOOR_SEAT_SEQ = ? WHERE EMP_ID = ?";
        jdbcTemplate.update(sql, seatSeq, empId);
        return getAllEmployees();
    }
}
