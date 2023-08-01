import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://127.0.0.1:8079/api/1.0/seats";

class SeatingChartService{
    getSeats(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
}

export default new SeatingChartService()