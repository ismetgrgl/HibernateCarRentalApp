package org.ismetg.utility;

import org.ismetg.entity.Arac;
import org.ismetg.entity.Kiralama;
import org.ismetg.entity.Kisi;
import org.ismetg.entity.enums.AracStatus;
import org.ismetg.entity.enums.KisiStatus;
import org.ismetg.repository.AracRepository;
import org.ismetg.repository.KiralamaRepository;
import org.ismetg.repository.KisiRepository;

public class DummyData {
    AracRepository aracRepository;
    KisiRepository kisiRepository;
    KiralamaRepository kiralamaRepository;

    public DummyData() {
        this.aracRepository = new AracRepository();
        this.kisiRepository = new KisiRepository();
        this.kiralamaRepository = new KiralamaRepository();
    }

    public void dataEkle(){
        Arac arac1 = Arac.builder()
                .marka("Skoda")
                .model("Octavia")
                .yil(2015)
                .aracStatus(AracStatus.BOSTA)
                .build();
        Arac arac2 = Arac.builder()
                .marka("Mazda")
                .model("RX-8")
                .yil(2007)
                .aracStatus(AracStatus.KIRADA)
                .build();
        Arac arac3 = Arac.builder()
                .marka("Audi")
                .model("R8")
                .yil(2018)
                .aracStatus(AracStatus.KIRADA)
                .build();

        aracRepository.save(arac1);
        aracRepository.save(arac2);
        aracRepository.save(arac3);

        Kisi kisi1 = Kisi.builder()
                .ad("Barış")
                .soyad("Demirci")
                .email("barışDemirci@bilgeadam.com")
                .tel("123456789")
                .tcKimlikNo("987654321")
                .konum("Istanbul")
                .kisiStatus(KisiStatus.ACTIVE)
                .build();

        Kisi kisi2 = Kisi.builder()
                .ad("Ismet")
                .soyad("Görgülü")
                .email("ismet@gmail.com")
                .tel("987654321")
                .tcKimlikNo("123456789")
                .konum("Ankara")
                .kisiStatus(KisiStatus.ACTIVE)
                .build();
        kisiRepository.save(kisi1);
        kisiRepository.save(kisi2);

        Kiralama kiralama1 = Kiralama.builder()
                .kisi(kisi1)
                .arac(arac3)
                .ucret(2000.00)
                .build();
        Kiralama kiralama2 = Kiralama.builder()
                .kisi(kisi2)
                .arac(arac2)
                .ucret(1000.00)
                .build();
        kiralamaRepository.save(kiralama1);
        kiralamaRepository.save(kiralama2);
    }

}
