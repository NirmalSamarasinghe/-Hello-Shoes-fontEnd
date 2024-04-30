package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.entity.CustomerEntity;
import lk.ijse.gdse.helloshoesbackend.repository.CustomerServiceDao;
import lk.ijse.gdse.helloshoesbackend.service.CustomerService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
       // customerDTO.setCustomerID(UUID.randomUUID().toString());
        return conversionData.convertoCustomerDTO(java.util.Optional.of(customerServiceDao.save(conversionData.convertToCustomerEntity(Optional.of(customerDTO)))));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return conversionData.convertCustomerDTOList(customerServiceDao.findAll());
    }

    @Override
    public CustomerDTO getCustomerByID(String customerID) {
        if (!customerServiceDao.existsById(customerID));
        return conversionData.convertoCustomerDTO(customerServiceDao.findById(customerID));
    }

    @Override
    public void deleteCustomerByID(String customerID) {
        customerServiceDao.deleteById(customerID);
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity>customer=customerServiceDao.findById(id);
        if(customer.isPresent()) {
            customer.get().setCustomerId(customerDTO.getCustomerID());
            customer.get().setCustomerName(customerDTO.getCustomerName());
            customer.get().setGender(customerDTO.getGender());
            customer.get().setJoinDate(customerDTO.getJoinDate());
            customer.get().setLevel(customerDTO.getLevel());
            customer.get().setTotalPoints(customerDTO.getTotalPoints());
            customer.get().setDateOfBirth(customerDTO.getDateOfBirth());
            customer.get().setAddress1(customerDTO.getAddress1());
            customer.get().setAddress2(customerDTO.getAddress2());
            customer.get().setAddress3(customerDTO.getAddress3());
            customer.get().setAddress4(customerDTO.getAddress4());
            customer.get().setAddress5(customerDTO.getAddress5());
            customer.get().setContact(customerDTO.getContact());
            customer.get().setEmail(customerDTO.getEmail());
            customer.get().setPurchaseTimeDate(String.valueOf(customerDTO.getPurchaseTimeDate()));

        }

    }

}