package lk.ijse.gdse.helloshoesbackend.controller;


import jakarta.validation.Valid;
import lk.ijse.gdse.helloshoesbackend.Enum.Gender;
import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lk.ijse.gdse.helloshoesbackend.Enum.Status;
import lk.ijse.gdse.helloshoesbackend.dto.EmployeeDTO;
import lk.ijse.gdse.helloshoesbackend.service.EmployeeService;
import lk.ijse.gdse.helloshoesbackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class Employee {
    private final EmployeeService employeeService;

    @GetMapping("/healthCheck")
    public String healthCheckEmployee(){
        return "Employee Health Check";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDTO saveEmployee(@Valid
                                    @RequestPart ("employee_name") String employeeName,
                                    @RequestPart("profile_picture") String profilePicture,
                                    @RequestPart("gender")String gender,
                                    @RequestPart("status")String status,
                                    @RequestPart("designation")String designation,
                                    @RequestPart("role")String accessRole,
                                    @RequestPart("date_of_birth")String dob,
                                    @RequestPart("attached_branch")String attached_branch,
                                    @RequestPart("address1")String addressLine01,
                                    @RequestPart("address2")String addressLine02,
                                    @RequestPart("address3")String addressLine03,
                                    @RequestPart("address4")String addressLine04,
                                    @RequestPart("postalCode")String postalCode,
                                    @RequestPart("contact_no")String contact_no,
                                    @RequestPart("email")String email,
                                    @RequestPart("name_of_the_guardian")String nameOfTheGuardian,
                                    @RequestPart("emergency_contact_no")String emergencyContactNo,
                                    Errors errors){
        if (errors.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_name(employeeName);
        employeeDTO.setProfile_picture(UtilMatters.convertToBase64(profilePicture));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(String.valueOf(Status.valueOf(status)));
        employeeDTO.setDesignation(designation);
        employeeDTO.setRole(Role.valueOf(accessRole));
        employeeDTO.setDate_of_birth(dob);
        employeeDTO.setAttached_branch(attached_branch);
        employeeDTO.setAddress1(addressLine01);
        employeeDTO.setAddress2(addressLine02);
        employeeDTO.setAddress3(addressLine03);
        employeeDTO.setAddress4(addressLine04);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContact_no(contact_no);
        employeeDTO.setEmail(email);
        employeeDTO.setName_of_the_guardian(nameOfTheGuardian);
        employeeDTO.setEmergency_contact_no(emergencyContactNo);

        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?>getEmployee (@PathVariable("id")String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?>getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateEmployee(@PathVariable("id")String id, @Valid
    @RequestPart ("employee_name") String employeeName,
                               @RequestPart("profile_picture") String profilePicture,
                               @RequestPart("gender")String gender,
                               @RequestPart("status")String status,
                               @RequestPart("designation")String designation,
                               @RequestPart("role")String accessRole,
                               @RequestPart("date_of_birth")String dob,
                               @RequestPart("attached_branch")String attached_branch,
                               @RequestPart("address1")String addressLine01,
                               @RequestPart("address2")String addressLine02,
                               @RequestPart("address3")String addressLine03,
                               @RequestPart("address4")String addressLine04,
                               @RequestPart("postalCode")String postalCode,
                               @RequestPart("contact_no")String contact_no,
                               @RequestPart("email")String email,
                               @RequestPart("name_of_the_guardian")String nameOfTheGuardian,
                               @RequestPart("emergency_contact_no")String emergencyContactNo,
                               org.springframework.validation.Errors errors){
            if(errors.hasFieldErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_name(employeeName);
        employeeDTO.setProfile_picture(UtilMatters.convertToBase64(profilePicture));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(String.valueOf(Status.valueOf(status)));
        employeeDTO.setDesignation(designation);
        employeeDTO.setRole(Role.valueOf(accessRole));
        employeeDTO.setDate_of_birth(dob);
        employeeDTO.setAttached_branch(attached_branch);
        employeeDTO.setAddress1(addressLine01);
        employeeDTO.setAddress2(addressLine02);
        employeeDTO.setAddress3(addressLine03);
        employeeDTO.setAddress4(addressLine04);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContact_no(contact_no);
        employeeDTO.setEmail(email);
        employeeDTO.setName_of_the_guardian(nameOfTheGuardian);
        employeeDTO.setEmergency_contact_no(emergencyContactNo);

        employeeService.updateEmployee(id,employeeDTO);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteEmployee(@PathVariable("id")String id){
        return employeeService.deleteEmployee(id);
    }
}
