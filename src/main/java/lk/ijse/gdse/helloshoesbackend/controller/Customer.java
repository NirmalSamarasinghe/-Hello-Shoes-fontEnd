package lk.ijse.gdse.helloshoesbackend.controller;

import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class Customer {

    public CustomerService customerService;

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Customer healthCheck";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO saveCustomer( @Validated @RequestBody CustomerDTO customerDTO) {
       return customerService.saveCustomer(customerDTO);
    }
}
