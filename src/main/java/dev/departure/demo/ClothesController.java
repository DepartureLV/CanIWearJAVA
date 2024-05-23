package dev.departure.demo.Clothes;

import dev.departure.demo.ClothesModel;
import dev.departure.demo.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
@RequiredArgsConstructor
@Validated
public class ClothesController {
    private final ClothesService clothesService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/clothes
     * Purpose: Fetches all the clothes in clothes table
     * @return List of Clothes
     */
    @GetMapping
    public ResponseEntity<List<ClothesModel>> getAllClothes() {
        return ResponseEntity.ok().body(clothesService.getAllClothes());
    }

    /**
     * this method is called when a GET request id made
     * URL: localhost:8080/clothes/{id}
     * Purpose: Fetch clothes with the given id
     * @param id - clothes id
     * @return Clothes with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClothesModel> getClothesById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clothesService.getClothesById(id));
    }

    /**
     * this method is called when a POST request is made
     * URL: localhost:8080/clothes
     * Purpose: Save a clothes entity
     * @param clothesModel - Request body is an Request entity
     * @return saved Clothes entity
     */
    @PostMapping
    public ResponseEntity<ClothesModel> saveClothes(@RequestBody ClothesModel clothesModel) {
        return ResponseEntity.ok().body(clothesService.saveClothes(clothesModel));
    }

    /**
     * this method is called when a PUT request is made
     * URL: localhost:8080/clothes
     * Purpose: Update the clothes entity
     * @param clothesModel - Clothes entity to be updated
     * @return Updated clothes
     */
    @PutMapping
    public ResponseEntity<ClothesModel> updateClothes(@RequestBody ClothesModel clothesModel) {
        return ResponseEntity.ok().body(clothesService.updateClothes(clothesModel));
    }

    /**
     * this method is called when DELETE request is made
     * URL: localhost:8080/clothes/{id}
     * Purpose: Delete the clothes entity
     * @param id - clothes's id to be deleted
     * @return a String message indicating clothes record has been deleted successfully or not
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClothes(@PathVariable Integer id) {
        clothesService.deleteClothes(id);
        return ResponseEntity.ok().body("Deleted clothes successfully");
    }
}
