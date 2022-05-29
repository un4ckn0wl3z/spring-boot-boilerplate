package net.unknownclub.Sprintboottut.service;

import net.unknownclub.Sprintboottut.entity.Department;
import net.unknownclub.Sprintboottut.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetDepartmentList();

    public Department fetDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
