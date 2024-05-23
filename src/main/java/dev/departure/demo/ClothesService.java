package dev.departure.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public List<ClothesModel> getAllClothes() {
        return clothesRepository.findAll();
    }

    public ClothesModel getClothesById(Integer id) {
        Optional<ClothesModel> optionalClothes = clothesRepository.findById(id);
        if (optionalClothes.isPresent()) {
            return optionalClothes.get();
        }
        log.info("Clothes with id: {} doesn't exist", id);
        return null;
    }

    public ClothesModel saveClothes(ClothesModel clothesModel) {
        clothesModel.setCreatedAt(LocalDateTime.now());
        clothesModel.setUpdatedAt(LocalDateTime.now());

        ClothesModel saveClothes = clothesRepository.save(clothesModel);

        log.info("Clothes with id: {} saved successfully", clothesModel.getId());
        return saveClothes;
    }

    public ClothesModel updateClothes(ClothesModel clothesModel) {
        Optional<ClothesModel> existingClothes = clothesRepository.findById(clothesModel.getId());
        clothesModel.setCreatedAt(existingClothes.get().getCreatedAt());
        clothesModel.setUpdatedAt(LocalDateTime.now());

        ClothesModel updatedClothes = clothesRepository.save(clothesModel);

        log.info("Clothes with id: {} updated successfully", clothesModel.getId());
        return updatedClothes;
    }

    public void deleteClothes(Integer id) {
        clothesRepository.deleteById(id);
    }


}
