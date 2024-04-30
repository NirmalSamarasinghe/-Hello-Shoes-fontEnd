package lk.ijse.gdse.helloshoesbackend.controller;

import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    private static int counter = 0;
    public static String generateID() {
        counter++;
        return String.format("CUS-%03d", counter);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO saveCustomer( @Validated @RequestBody CustomerDTO customerDTO) {
        customerDTO.setCustomerID(generateID());
       return customerService.saveCustomer(customerDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping(value = "/{customerID}")
    public ResponseEntity<?> getCustomerByID(@PathVariable String customerID) {
        return ResponseEntity.ok(customerService.getCustomerByID(customerID));
    }
    @DeleteMapping(value = "/{customerID}")
    public ResponseEntity<?> deleteCustomerByID(@PathVariable String customerID) {
        customerService.deleteCustomerByID(customerID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details deleted Successfully.");
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@Validated @PathVariable("id") String id, @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().toString());
        }
        try {
            customerService.updateCustomer(id, customerDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details updated Successfully.");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error | Customer Details updated Unsuccessfully.\nMore Details\n"+e);
        }

    }
}
