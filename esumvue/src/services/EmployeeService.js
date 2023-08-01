import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://127.0.0.1:8079/api/1.0/users";

class EmployeeService{
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    setSeat(emp_id, seat_id){
        const formdata = new FormData();
        formdata.append('empId', emp_id);
        formdata.append('seatSeq', seat_id);
        return axios.patch(EMPLOYEE_API_BASE_URL,
                            formdata,
                            { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } }
                        );
    }
}

export default new EmployeeService()