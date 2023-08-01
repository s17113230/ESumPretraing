package com.example.esumspring;

import com.example.esumspring.model.Employee;
import com.example.esumspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/1.0")
@CrossOrigin("http://localhost:8080")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/users")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PatchMapping("/users")
    public List<Employee> updateSeatSeqByEmpId(@RequestParam("empId") Integer empId,@RequestParam("seatSeq") Integer seatSeq){
        return employeeService.updateSeatSeqByEmpId(empId, seatSeq);
    }
}
