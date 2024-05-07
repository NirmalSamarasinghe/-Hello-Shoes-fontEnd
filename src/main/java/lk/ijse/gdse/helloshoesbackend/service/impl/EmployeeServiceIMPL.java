package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.Enum.Status;
import lk.ijse.gdse.helloshoesbackend.controller.User;
import lk.ijse.gdse.helloshoesbackend.dto.EmployeeDTO;
import lk.ijse.gdse.helloshoesbackend.entity.EmployeeEntity;
import lk.ijse.gdse.helloshoesbackend.entity.UserEntity;
import lk.ijse.gdse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.gdse.helloshoesbackend.repository.EmployeeServiceDao;
import lk.ijse.gdse.helloshoesbackend.repository.UserServiceDao;
import lk.ijse.gdse.helloshoesbackend.service.EmployeeService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService{

    private final EmployeeServiceDao employeeServiceDao;
    private final ConversionData conversionData;
    private final UserServiceDao userServiceDao;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployee_code(getNextEmployeeCode());
        EmployeeEntity employeeEntity = conversionData.toEmployeeEntity(employeeDTO);

        String email=employeeDTO.getEmail();
        Optional<UserEntity>byEmail=userServiceDao.findByEmail(email);

        if(byEmail == null){
            throw new NotFoundException("User Not Found");
        }
        UserEntity user= new UserEntity();
        user.setUserId(byEmail.get().getUserId());
        user.setEmail(email);
        user.setPassword(byEmail.get().getPassword());
        user.setRole(byEmail.get().getRole());

        employeeEntity.setUserEntity(user);
        return conversionData.toEmployeeDTO(Optional.of(employeeServiceDao.save(employeeEntity)));
    }

    @Override
    public EmployeeDTO getEmployee(String id) {
        if (!employeeServiceDao.existsById(id)) {
            throw new NotFoundException("Employee Not Found");
        }
        return conversionData.toEmployeeDTO(employeeServiceDao.findById(id));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return conversionData.toEmployeeDTOList(employeeServiceDao.findAll());
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        if (!employeeServiceDao.existsById(id)) {
            throw new NotFoundException("Employee not found");
        }
        Optional<EmployeeEntity>employeeEntity=employeeServiceDao.findById(id);
        EmployeeEntity employeeEntity1 = employeeEntity.get();
        employeeEntity1.setEmployee_name(employeeDTO.getEmployee_name());
        employeeEntity1.setProfile_picture(employeeDTO.getProfile_picture());
        employeeEntity1.setGender(employeeDTO.getGender());
        employeeEntity1.setStatus(Status.valueOf(employeeDTO.getStatus()));
        employeeEntity1.setDesignation(employeeDTO.getDesignation());
        employeeEntity1.setRole(employeeDTO.getRole());
        employeeEntity1.setDate_of_birth(employeeDTO.getDate_of_birth());
        employeeEntity1.setAttached_branch(employeeDTO.getAttached_branch());
        employeeEntity1.setAddress1(employeeDTO.getAddress1());
        employeeEntity1.setAddress2(employeeDTO.getAddress2());
        employeeEntity1.setAddress3(employeeDTO.getAddress3());
        employeeEntity1.setAddress4(employeeDTO.getAddress4());
        employeeEntity1.setPostalCode(employeeDTO.getPostalCode());
        employeeEntity1.setContact_no(employeeDTO.getContact_no());
        employeeEntity1.setEmail(employeeDTO.getEmail());
        employeeEntity1.setName_of_the_guardian(employeeDTO.getName_of_the_guardian());
        employeeEntity1.setEmergency_contact_no(employeeDTO.getEmergency_contact_no());
    }

    @Override
    public boolean deleteEmployee(String id) {
        if (!employeeServiceDao.existsById(id)) {
            throw new NotFoundException("Employee Not Found");
        }
        employeeServiceDao.deleteById(id);
        return true;
    }


    private String getNextEmployeeCode(){
        EmployeeEntity employeeEntity=employeeServiceDao.findByOrderByEmployeeCodeDesc();
        return (employeeEntity !=null)
                ? String.format("EMP-%03d",
                Integer.parseInt(employeeEntity.getEmployeeCode()
                        .replace("EMP-", "")) +1)
                : "EMP-001";
    }
}
