package lk.ijse.gdse.helloshoesbackend.util;

import lk.ijse.gdse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.gdse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.gdse.helloshoesbackend.dto.UserDTO;
import lk.ijse.gdse.helloshoesbackend.entity.CustomerEntity;
import lk.ijse.gdse.helloshoesbackend.entity.SupplierEntity;
import lk.ijse.gdse.helloshoesbackend.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConversionData {
    final private ModelMapper modelMapper;

    public CustomerDTO convertoCustomerDTO(Optional<CustomerEntity> customerEntity){
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }
    public CustomerEntity convertToCustomerEntity(Optional<CustomerDTO> customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }
    public List<CustomerDTO>convertCustomerDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList,List.class);
    }
    public List<CustomerEntity>getCustomerEntityList(List<CustomerDTO> customerDTOList){
        return modelMapper.map(customerDTOList,List.class);
    }


    public SupplierDTO convertToSupplierDTO(Optional<SupplierEntity> supplierEntity){
        return modelMapper.map(supplierEntity, SupplierDTO.class);
    }

    public SupplierEntity convertToSupplierEntity(Optional<SupplierDTO> supplierDTO){
        return modelMapper.map(supplierDTO, SupplierEntity.class);
    }

    public List<SupplierDTO> getSupplierDTOList(List<SupplierEntity> supplierEntities){
        return modelMapper.map(supplierEntities,List.class);
    }

    public List<SupplierEntity> getSupplierEntityList(List<SupplierEntity> supplierDTOs){
        return modelMapper.map(supplierDTOs,List.class);
    }

    public UserEntity toUser(UserDTO build) {
        return modelMapper.map(build, UserEntity.class);
    }
}
