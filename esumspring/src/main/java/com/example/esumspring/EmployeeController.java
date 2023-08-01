package com.example.esumspring;

import com.example.esumspring.common.XssFilters;
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
        if (XssFilters.stripXSS(String.valueOf(empId)).equals("具有非法關鍵字") || XssFilters.stripXSS(String.valueOf(seatSeq)).equals("具有非法關鍵字")){
            return null;
        }
        empId = Integer.parseInt(XssFilters.stripXSS(String.valueOf(empId)));
        seatSeq = Integer.parseInt(XssFilters.stripXSS(String.valueOf(seatSeq)));
        return employeeService.updateSeatSeqByEmpId(empId, seatSeq);
    }
}
