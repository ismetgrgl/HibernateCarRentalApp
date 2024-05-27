package org.ismetg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.ismetg.entity.enums.KiralamaStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblkiralama")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Kisi kisi;
    @ManyToOne
    Arac arac;
    Double ucret;
    @Enumerated(EnumType.STRING)
    KiralamaStatus kiralamaStatus;
    @CreationTimestamp
    LocalDate creatAt;
    @UpdateTimestamp
    LocalDate updateAt;
}
