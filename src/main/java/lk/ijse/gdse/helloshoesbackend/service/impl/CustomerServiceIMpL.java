package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.repository.CustomerServiceDao;
import lk.ijse.gdse.helloshoesbackend.service.CustomerService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class CustomerServiceIMpL implements CustomerService {

    private final ConversionData conversionData;
    private final CustomerServiceDao customerServiceDao;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerID(UUID.randomUUID().toString());
        return conversionData.convertoCustomerDTO(java.util.Optional.of(customerServiceDao.save(conversionData.convertToCustomerEntity(Optional.of(customerDTO)))));
    }
}