package net.unknownclub.Sprintboottut.controller;

import net.unknownclub.Sprintboottut.entity.Department;
import net.unknownclub.Sprintboottut.error.DepartmentNotFoundException;
import net.unknownclub.Sprintboottut.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Bangkok")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Bangkok")
                .departmentName("IT")
                .departmentCode("IT-06")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(
                post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\": \"IT\",\n" +
                                "    \"departmentAddress\": \"Bangkok\",\n" +
                                "    \"departmentCode\": \"IT-06\"\n" +
                                "}")
        ).andExpect(status().isOk());
    }

    @Test
    void fetDepartmentById() throws Exception {
        Mockito.when(departmentService.fetDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(
                get("/departments/1").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}