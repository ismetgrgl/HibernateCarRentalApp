package org.ismetg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.ismetg.entity.enums.KisiStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@NamedQuery(
        name = "kisiIdyeGoreKiralamaBul",
        query = "SELECT k FROM Kiralama k WHERE k.kisi.id = :kisiId")

@Table(name = "tblkisi")
public class Kisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String tel;
    @Column(unique = true)
    String email;
    @Column(unique = true)
    String tcKimlikNo;
    String konum;
    @Enumerated(EnumType.STRING)
    KisiStatus kisiStatus;
    @CreationTimestamp
    LocalDate creatAt;
    @UpdateTimestamp
    LocalDate updateAt;
}
