package com.springtutorial.ems.mapper;

import com.springtutorial.ems.dto.EmployeeDto;
import com.springtutorial.ems.entity.Employee;

public class EmployeeMapper {
public static EmployeeDto mapToEmployeeDto(Employee employee) {
    return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
    );
}
public static Employee mapToEmployee(EmployeeDto employeeDto) {
    return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
    );
}
}
