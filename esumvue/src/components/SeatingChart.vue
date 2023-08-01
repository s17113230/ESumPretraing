<template>
    <div class="container">
        <h1 class="text-center">Employees List</h1>
        <table class="table table-striped">
            <thead>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Employee Email</th>
                <th>Employee Phone</th>
            </thead>
            <tbody>
                <tr v-for="employee in employees" v-bind:key = "employee.id">
                    <td>{{employee.id}}</td>
                    <td>{{employee.name}}</td>
                    <td>{{employee.email}}</td>
                    <td>{{employee.phone}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import EmployeeSerivce from '../services/EmployeeService'
    export default {
        name: 'SeatingChart',
        data() {
            return {
                employees: []
            }
        },
        methods:{
            getEmployes(){
                EmployeeSerivce.getEmployees().then((response) => {
                    this.employees = response.data
                })
            }
        },
        created() {
            this.getEmployes()
        }
    }
</script>