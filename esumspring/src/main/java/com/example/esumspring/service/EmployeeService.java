package com.example.esumspring.service;

import com.example.esumspring.model.Employee;
import com.example.esumspring.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

    public List<Employee> updateSeatSeqByEmpId(Integer empId, Integer seatSeq){
        if (seatSeq <= 0)
            seatSeq = null;
        return employeeDAO.updateSeatSeqByEmpId(empId, seatSeq);
    }
}
