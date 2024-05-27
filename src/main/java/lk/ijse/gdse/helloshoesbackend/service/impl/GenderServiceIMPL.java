package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.dao.GenderDao;
import lk.ijse.gdse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.gdse.helloshoesbackend.service.GenderService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class GenderServiceIMPL implements GenderService {

    private final GenderDao genderDao;
    private final ConversionData conversionData;

    @Override
    public void saveGender(GenderDTO genderDTO) {
        genderDao.save(conversionData.toGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> getAllGender() {
        return conversionData.toGenderDTOList(genderDao.findAll());
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        genderDao.save(conversionData.toGenderEntity(genderDTO));
    }

    @Override
    public boolean deleteGender(String id) {
        genderDao.deleteById(id);
        return true;
    }
}
