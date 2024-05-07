package lk.ijse.gdse.helloshoesbackend.service;

import lk.ijse.gdse.helloshoesbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(String id);

    List<EmployeeDTO> getAllEmployee();

    void updateEmployee(String id, EmployeeDTO employeeDTO);

    boolean deleteEmployee(String id);
}
