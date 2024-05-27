package lk.ijse.gdse.helloshoesbackend.controller;

import lk.ijse.gdse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.gdse.helloshoesbackend.service.GenderService;
import lk.ijse.gdse.helloshoesbackend.service.InventoryService;
import lk.ijse.gdse.helloshoesbackend.service.OccasionService;
import lk.ijse.gdse.helloshoesbackend.service.VarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/inventory")
public class Inventory {
   private final GenderService genderService;
   /* private final OccasionService occasionService;
    private final VarietyService varietyService;
    private final InventoryService inventoryService;*/

    @GetMapping("/Inventory Health")
    public String healthCheckInventory(){
        return "Inventory Health Check";
    }
    @PostMapping("/saveGender")
    public void saveGender(@RequestBody GenderDTO genderDTO){
        genderService.saveGender(genderDTO);
    }
    @GetMapping("/getAllGender")
    public ResponseEntity<?>getAllGender(){
        return ResponseEntity.ok(genderService.getAllGender());
    }
    @PatchMapping(value = "/{genderId}")
    public void updateGender(@PathVariable("genderId")String genderId,@RequestBody GenderDTO genderDTO){
        genderService.updateGender(genderId, genderDTO);
    }
    @DeleteMapping(value = "/{genderId}",produces = "application/json")
    public void deleteGender(@PathVariable("genderId")String genderId){
        genderService.deleteGender(genderId);
    }
}
