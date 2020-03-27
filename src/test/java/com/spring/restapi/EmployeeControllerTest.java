package com.spring.restapi;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void getAllEmployees()throws Exception{
//        List<Employee> employeeList = new ArrayList<Employee>();
//        employeeList.add(new Employee(1L,"mamang", "mamang@example","Jl.Aren"));
//        employeeList.add(new Employee(2L,"memeng", "memeng@example","Jl.Bambu"));
//        when(employeeService.getAllEmployees()).thenReturn(employeeList);

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/").accept(MediaType.APPLICATION_JSON));
    }
}
