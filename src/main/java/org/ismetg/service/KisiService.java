package org.ismetg.service;

import org.ismetg.entity.Kiralama;
import org.ismetg.entity.Kisi;
import org.ismetg.entity.enums.KisiStatus;
import org.ismetg.repository.KisiRepository;

import java.util.List;

public class KisiService {
    KisiRepository kisiRepository;

    public KisiService() {
        this.kisiRepository = new KisiRepository();
    }

    /**
     * gelen verileri Databaseye kaydediyor.
     * @param ad KisiController sınıfından gelen veriler.
     */
    public void kisiDBIsle(String ad, String soyad, String telefon , String email , String tcKimlikNo , String konum){
        Kisi kisi = Kisi.builder()
                .ad(ad)
                .soyad(soyad)
                .tel(telefon)
                .email(email)
                .tcKimlikNo(tcKimlikNo)
                .konum(konum)
                .kisiStatus(KisiStatus.ACTIVE)
                .build();
        kisiRepository.save(kisi);
    }

    /**
     * girilen idye göre kiralanan araçları veriyor.
     * @param id dışardan alınan idye göre kiralama bulmak için.
     */
    public void idyeGoreAraclariBul(Long id){
        List<Kiralama> kiralamaByKisiId = kisiRepository.findKiralamaByKisiId(id);
        if (!kiralamaByKisiId.isEmpty()){
            System.out.println(kiralamaByKisiId.getFirst().getArac());
        }
        else {
            System.out.println("Girilen id'de kimse yok");
        }

    }
}
