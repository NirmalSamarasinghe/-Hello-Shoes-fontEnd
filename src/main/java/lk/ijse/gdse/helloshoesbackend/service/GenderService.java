package lk.ijse.gdse.helloshoesbackend.service;

import lk.ijse.gdse.helloshoesbackend.dto.GenderDTO;

import java.util.List;

public interface GenderService {
    void saveGender(GenderDTO genderDTO);
    List<GenderDTO> getAllGender();

    void updateGender(String id, GenderDTO genderDTO);

    boolean deleteGender(String id);
}
