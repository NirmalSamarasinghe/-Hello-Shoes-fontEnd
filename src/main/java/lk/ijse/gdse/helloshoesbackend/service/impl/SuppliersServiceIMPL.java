package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.gdse.helloshoesbackend.entity.SupplierEntity;
import lk.ijse.gdse.helloshoesbackend.repository.SupplierServiceDao;
import lk.ijse.gdse.helloshoesbackend.service.SupplierService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class SuppliersServiceIMPL implements SupplierService {
    private final ConversionData conversionData;
    private final SupplierServiceDao supplierServiceDao;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return conversionData.convertToSupplierDTO(Optional.of(supplierServiceDao.save(conversionData.convertToSupplierEntity(Optional.ofNullable(supplierDTO)))));
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return conversionData.getSupplierDTOList(supplierServiceDao.findAll());
    }

    @Override
    public void deleteSupplierById(String supplierId) {
        supplierServiceDao.deleteById(supplierId);
    }

    @Override
    public SupplierDTO getSupplierByID(@PathVariable String supplierID) {
        if (!supplierServiceDao.existsById(supplierID));
        return conversionData.convertToSupplierDTO(supplierServiceDao.findById(supplierID));
    }

    @Override
    public void updateSupplier(String supplierId, SupplierDTO supplierDTO) {
        Optional<SupplierEntity>supplier=supplierServiceDao.findById(supplierId);
        if (supplier.isPresent()) {
            supplier.get().setSupplierCode(supplierDTO.getSupplierCode());
            supplier.get().setSupplierName(supplierDTO.getSupplierName());
            supplier.get().setCategory(supplierDTO.getCategory());
            supplier.get().setAddress1(supplierDTO.getAddress1());
            supplier.get().setAddress2(supplierDTO.getAddress2());
            supplier.get().setAddress3(supplierDTO.getAddress3());
            supplier.get().setAddress4(supplierDTO.getAddress4());
            supplier.get().setPostalCode(supplierDTO.getPostalCode());
            supplier.get().setCountry(supplierDTO.getCountry());
            supplier.get().setContactNo1(supplierDTO.getContactNo1());
            supplier.get().setContactNo2(supplierDTO.getContactNo2());
            supplier.get().setEmail(supplierDTO.getEmail());
        }
    }
}