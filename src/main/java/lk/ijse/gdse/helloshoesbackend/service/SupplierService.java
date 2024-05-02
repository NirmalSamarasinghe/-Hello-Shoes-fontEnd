package lk.ijse.gdse.helloshoesbackend.service;

import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    List <SupplierDTO>getAllSupplier();

    void deleteSupplierById(String supplierId);

    SupplierDTO getSupplierByID(String supplierID);

    void updateSupplier(String SupplierId, SupplierDTO supplierDTO);
}
