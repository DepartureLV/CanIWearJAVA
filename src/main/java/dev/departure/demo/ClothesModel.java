package dev.departure.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clothes")
public class ClothesModel {
    @Id
    private Integer id;
    private String type;
    private String name;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
