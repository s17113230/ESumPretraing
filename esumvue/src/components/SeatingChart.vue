<template>
    <div class="container">
        <h1 class="text-center">座位表</h1>
        
        <div class="row" v-for="row in seatMap" :key="row.rowNumber">
            <div class="col-3 seat mb-1 p-3" 
                :class="{ 'occupied': seat.occupied, 'chosen': seat.chosen}" 
                @click="toggleSeatStatus(seat)" 
                :value="seat.seatseq"
                :empId="seat.empId"
                v-for="seat in row.seats" :key="seat.name">
                {{ seat.name }}
            </div>
        </div>

        <div class="row">
            <label class="text-start"><div class="me-2" style="background-color: rgba(212, 212, 212, 0.623);width:30px;height:30px;display: inline-table;"></div>空位</label>
            <label class="text-start"><div class="me-2" style="background-color: red;width:30px;height:30px;display: inline-table;"></div>已佔用</label>
            <label class="text-start"><div class="me-2" style="background-color: rgba(17, 194, 76, 0.623);width:30px;height:30px;display: inline-table;"></div>請選擇</label>
            <button type="button" class="btn btn-primary" style="width:auto" data-bs-toggle="modal" data-bs-target="#employeeModal" @click="showModal()">送出</button>
        </div>
    </div>
    
    <div class="modal fade" id="employeeModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="employeeModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="employeeModalLabel">選擇員工</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <select class="form-select" id="EmployeesSelection"></select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" @click="submitEmployee()">確定</button>
            </div>
            </div>
        </div>
    </div>
</template>
  
<script>
    import SeatingChartSerivce from '../services/SeatingChartService';
    import EmployeeService from '../services/EmployeeService';
    export default {
        data() {
            return {
                seatMap: [],
            }
        },
        methods:{
            getSeats(){
                let floorNumber = 0;
                let tempSeats = [];
                
                //設定座位表，已有座位的員工會被設定為occupied
                SeatingChartSerivce.getSeats().then((response) => {
                    response.data.forEach(element => {
                        if(floorNumber == 0) floorNumber = element['floor_NO'];
                        if(floorNumber != element['floor_NO']){
                            let map = {
                                rowNumber: floorNumber,
                                seats: tempSeats
                            }
                            this.seatMap.push(map);
                            tempSeats = [];
                            floorNumber = element['floor_NO'];
                        }

                        let seat = createSeatObject(element['floor_NO'], element['seat_NO'], element['emp_ID'], element['floor_SEAT_SEQ']);
                        tempSeats.push(seat);
                    });
                    let map = {
                        rowNumber: floorNumber,
                        seats: tempSeats
                    }
                    this.seatMap.push(map);
                })

                //將還沒安排座位的員工加入選單
                EmployeeService.getEmployees().then((response) => {
                    let employeeSelect = document.getElementById("EmployeesSelection");
                    response.data.forEach(element => {
                        if(element['floor_SEAT_SEQ'] != 0) return;
                        employeeSelect.options.add(new Option(element['emp_ID'].toString().padStart(5, '0')+"-"+element['name'], element['emp_ID']));
                    });
                })
            },

            //當點擊座位時，切換座位的狀態
            toggleSeatStatus(seat) {
                let chosenSeats = document.getElementsByClassName("seat chosen");
                if(chosenSeats.length > 0 && !seat.chosen){
                    alert("只能選擇一個座位");
                    return;
                }
                seat.chosen = !seat.chosen;
            },
            
            //送出員工選擇的座位，如果選擇的座位已有人坐，則取消該員工的座位
            submitEmployee(){
                let employee = document.getElementById("EmployeesSelection").value;
                let chosenSeats = document.getElementsByClassName("seat chosen")[0].getAttribute('value');
                let occupiedEmployee = document.getElementsByClassName("seat chosen")[0].getAttribute('empid');
                if(occupiedEmployee > 0){
                    employee = occupiedEmployee;
                    chosenSeats = 0;
                }

                EmployeeService.setSeat(employee, chosenSeats).then(() => {
                    alert("成功");
                    window.location.reload();
                })
            },

            //根據所選得座位修正modal的內容，如果選擇的座位已有人坐，則顯示取消座位
            showModal(){
                let chosenSeats = document.getElementsByClassName("seat chosen");
                if(chosenSeats.length > 0 && chosenSeats[0].className.indexOf("occupied") > 0){
                    document.getElementById("employeeModalLabel").innerHTML = "取消座位";
                    document.getElementsByClassName("modal-body")[0].style="display:none";
                } else{
                    document.getElementById("employeeModalLabel").innerHTML = "選擇員工";
                    document.getElementsByClassName("modal-body")[0].style="display:block";
                }
            }
        },
        created() {
            this.getSeats()
        }
    }

    // 建立座位物件
    function createSeatObject(floorNumber, seatNumber, empId = 0, floor_SEAT_SEQ) {
        const seatName = `${floorNumber}樓: 座位${seatNumber}`;
        const occupied = empId !== 0;
        const name = occupied ? `${seatName} [員編: ${empId.toString().padStart(5, '0')}]` : seatName;
        const seatseq = floor_SEAT_SEQ;
        return {
            name,
            occupied,
            chosen: false,
            seatseq,
            empId
        };
    }
</script>
  
<style>
    .seat {
        height: auto;
        display: flex;
        align-items: center;
        justify-content: center;
        border: 5px solid #ffffff;
        border-radius:20px;
        background-color: rgba(212, 212, 212, 0.623);
        cursor: pointer;
    }

    .occupied {
        background-color: red;
        color: white;
    }

    .chosen {
        background-color: rgba(17, 194, 76, 0.623);
        color: white;
    }
</style>