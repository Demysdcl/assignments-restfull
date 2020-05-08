package com.wipro.employeews.context;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public List<Employee> findByEmpLocation(String empLocation) {
        employeeDAO.openConnecton();
        List<Employee> findByEmpLocation = employeeDAO.findByEmpLocation(empLocation);
        employeeDAO.closeConnection();
        return findByEmpLocation;
    }

    public List<Employee> findByEmpBand(String empBand) {
        employeeDAO.openConnecton();
        List<Employee> findByEmpBand = employeeDAO.findByEmpBand(empBand);
        employeeDAO.closeConnection();
        return findByEmpBand;
    }

    public List<Employee> findAll() {
        employeeDAO.openConnecton();
        List<Employee> findAll = employeeDAO.findAll();
        employeeDAO.closeConnection();
        return findAll;
    }

    public void save(Employee employee) {
        employeeDAO.openConnecton();
        Optional<Employee> optional = employeeDAO.findById(employee.getEmpId());
        if (optional.isPresent()) {
            throw new RuntimeException(
                String.format("Id %s already exists", employee.getEmpId()));
        }
        employeeDAO.save(employee);
        employeeDAO.closeConnection();
    }

    void update(String empId, Employee employee) {
        employeeDAO.openConnecton();
        Optional<Employee> findById = employeeDAO.findById(empId);
        if (!findById.isPresent()) {
            throw new RuntimeException(
                String.format("Employee with ID: %s not found", employee.getEmpId()));
        }
        employee.setEmpId(empId);
        employeeDAO.update(employee);
        employeeDAO.closeConnection();
    }

}
