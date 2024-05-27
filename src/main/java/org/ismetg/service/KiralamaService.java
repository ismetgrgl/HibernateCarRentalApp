package org.ismetg.service;

import org.ismetg.entity.Arac;
import org.ismetg.entity.Kiralama;
import org.ismetg.entity.Kisi;
import org.ismetg.entity.enums.AracStatus;
import org.ismetg.repository.AracRepository;
import org.ismetg.repository.KiralamaRepository;
import org.ismetg.repository.KisiRepository;

import java.util.Optional;

public class KiralamaService {
    KiralamaRepository kiralamaRepository;
    AracRepository aracRepository;
    KisiRepository kisiRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
        this.aracRepository = new AracRepository();
        this.kisiRepository = new KisiRepository();
    }
    public void DByeKiralamaEkle(Long aracId , Long kisiId ,Double ucret){
        Optional<Arac> arac = aracRepository.findById(aracId);
        Optional<Kisi> kisi = kisiRepository.findById(kisiId);
        if (arac.get().getAracStatus() == AracStatus.KIRADA){
            System.out.println("Bu araç zaten kirada. Tekrar kiralanamaz.");
            return;
        }

        if (arac.isPresent()){
            if (kisi.isPresent()){
                Kiralama kiralama = Kiralama.builder()
                        .arac(arac.get())
                        .kisi(kisi.get())
                        .ucret(ucret)
                        .build();
                kiralamaRepository.save(kiralama);


            }
            else {
                System.out.println("Girdiğiniz id ile bir kişi bulunamadı.");
            }
        }
    }
}
