package com.spring.restapi;

import com.spring.restapi.module.employee.Employee;
import com.spring.restapi.module.employee.EmployeeResponseModel;
import com.spring.restapi.module.employee.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EmployeeControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean private EmployeeService employeeService;

    private Employee generateEmployee(){
        Long id = 1L;
        Employee newEmployee = new Employee(id,"albert", "albert@example","Jl.Aren");
        return newEmployee;
    }

    @Test
    void testGetAllEmployees()throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1L,"albert", "albert@example","Jl.Aren"));
        employees.add(new Employee(2L,"alan", "alan@example","Jl.Bambu"));

        EmployeeResponseModel model = new EmployeeResponseModel();
        model.setCode(RestStatus.SUCCESS.getCode());
        model.setStatus(RestStatus.SUCCESS.getMessage());
        model.setEmployees(employees);
        when(employeeService.getAllEmployees()).thenReturn(model);

        Assert.assertEquals(2, employees.size());
    }

    @Test
    void testCreateNewEmployee()throws Exception {
        Employee expectedEmployee = generateEmployee();
        when(employeeService.addEmployee(expectedEmployee)).thenReturn(expectedEmployee);

        Employee actualEmployee = employeeService.addEmployee(expectedEmployee);

        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void testUpdateEmployee()throws Exception {
        Employee expectedEmployee = generateEmployee();
        Long idToUpdate = 2L;
        when(employeeService.updateEmployee(idToUpdate, expectedEmployee)).thenReturn(expectedEmployee);

        Employee actualEmployee = employeeService.updateEmployee(idToUpdate, expectedEmployee);

        Assert.assertEquals(expectedEmployee.getEmployeeName(), actualEmployee.getEmployeeName());
    }

    @Test
    void testDeleteEmployee()throws Exception {
        Long idToDelete = 2L;

        employeeService.deleteEmployee(idToDelete);
        verify(employeeService, atLeast(1)).deleteEmployee(idToDelete);
    }
}
