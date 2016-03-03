package com.imaginea.dto;

import java.util.ArrayList;

/**
 * Created by pranavs on 3/3/2016.
 */
public class EmployeeBeanList {

    public ArrayList<Employee> getEmployeeBeanList() {
        ArrayList<Employee> employeeBeanList = new ArrayList<Employee>();

        employeeBeanList.add(produce("1101", "Megha Garg", "Development", "mega123@test.com"));
        employeeBeanList.add(produce("1102", "Gaurav Saxena", "Development", "gaurav123@gmail.com"));
        employeeBeanList.add(produce("1103", "Mohit Sharma", "HR", "mohit@gmail.com"));
        employeeBeanList.add(produce("1104", "Veernadra Varade", "Finance", "mohit@gmail.com"));
        employeeBeanList.add(produce("1105", "Soni Bansal", "QA", "soni@gmail.com"));


        return employeeBeanList;
    }

    private Employee produce(String id, String name, String department, String email) {
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setEmailId(email);
        return employee;
    }

}
