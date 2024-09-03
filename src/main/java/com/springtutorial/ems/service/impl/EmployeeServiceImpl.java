package com.springtutorial.ems.service.impl;

import com.springtutorial.ems.dto.EmployeeDto;
import com.springtutorial.ems.entity.Employee;
import com.springtutorial.ems.exception.ResourceNotFoundException;
import com.springtutorial.ems.mapper.EmployeeMapper;
import com.springtutorial.ems.repository.EmployeeRepository;
import com.springtutorial.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
               new ResourceNotFoundException("No existe el empleado con el id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) ->  EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }
}
