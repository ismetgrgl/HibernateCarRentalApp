package org.ismetg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.ismetg.entity.enums.AracStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@NamedQuery(name = "BostaOlanAraclar", query = "SELECT a FROM Arac a WHERE a.aracStatus = :status")
@Table(name = "tblarac")
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marka;
    String model;
    Integer yil;
    @Enumerated(EnumType.STRING)
    AracStatus aracStatus;
    @CreationTimestamp
    LocalDate creatAt;
    @UpdateTimestamp
    LocalDate updateAt;
}
