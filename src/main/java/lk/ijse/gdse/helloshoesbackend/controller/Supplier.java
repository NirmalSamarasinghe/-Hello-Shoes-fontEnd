package lk.ijse.gdse.helloshoesbackend.controller;

import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.gdse.helloshoesbackend.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/supplier")
@AllArgsConstructor
public class Supplier {

    public SupplierService supplierService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "Supplier Service is running";
    }

    private static int counter = 0;
    public static String generateID() {
        counter++;
        return String.format("Sup-%03d", counter);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDTO supplierSave(@Validated @RequestBody SupplierDTO supplierDTO){
        supplierDTO.setSupplierCode(generateID());
        return supplierService.saveSupplier(supplierDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getAllSupplier(){
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getSupplierByID(@PathVariable ("id")String supplierID) {
        return ResponseEntity.ok(supplierService.getSupplierByID(supplierID));
    }

    @DeleteMapping(value = "/{id}")
        public ResponseEntity<?>deleteSupplierByID(@PathVariable ("id")String supplierID){
        supplierService.deleteSupplierById(supplierID);
        return ResponseEntity.status(HttpStatus.OK).body("Supplier Details deleted Successfully.");
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSupplier(@Validated @PathVariable("id") String id, @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().toString());
        }try {
            supplierService.updateSupplier(id, supplierDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier Details updated Successfully.");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error | Supplier Details updated Unsuccessfully.\nMore Details\n"+e);
        }
    }
}
