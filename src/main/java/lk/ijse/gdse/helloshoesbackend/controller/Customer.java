package lk.ijse.gdse.helloshoesbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class Customer {
    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Customer healthCheck";
    }

}
