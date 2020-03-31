package com.spring.restapi;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.services.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Employee generateEmployee(){
        Employee newEmployee = new Employee(1L,"albert", "albert@example","Jl.Aren");
        return newEmployee;
    }

    @Test
    void getAllEmployees()throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1L,"albert", "albert@example","Jl.Aren"));
        employeeList.add(new Employee(2L,"alan", "alan@example","Jl.Bambu"));
        when(employeeService.getAllEmployees()).thenReturn(employeeList);
    }

    @Test
    void createNewEmployee()throws Exception {
        Employee expectedEmployee = generateEmployee();
        when(employeeService.addEmployee(expectedEmployee)).thenReturn(expectedEmployee);

        Employee actualEmployee = employeeService.addEmployee(expectedEmployee);

        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void updateEmployee()throws Exception {
        Employee expectedEmployee = generateEmployee();
        Employee currEmployee = new Employee(2L, "employee1", "example@Example", "Jl.XYZ");
        when(employeeService.updateEmployee(currEmployee, expectedEmployee)).thenReturn(currEmployee);

        Assert.assertEquals(expectedEmployee.getName(), currEmployee.getName());
    }
}
