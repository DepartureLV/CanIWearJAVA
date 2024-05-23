package dev.departure.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<ClothesModel, Integer> {
}
