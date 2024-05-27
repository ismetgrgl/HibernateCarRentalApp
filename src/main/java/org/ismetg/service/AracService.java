package org.ismetg.service;

import org.ismetg.entity.Arac;
import org.ismetg.entity.enums.AracStatus;
import org.ismetg.repository.AracRepository;

import java.util.List;
import java.util.Optional;


public class AracService {
    AracRepository aracRepository;

    public AracService() {
        this.aracRepository = new AracRepository();
    }

    public void aracDBIsle(String marka, String model , Integer yil){
        Arac arac = Arac.builder()
                .marka(marka)
                .model(model)
                .yil(yil)
                .aracStatus(AracStatus.BOSTA)
                .build();
        aracRepository.save(arac);
    }

    /**
     * findById hazır metodundan gelen aracı yazdıran metod.
     * @param id AracController katmanında aracArama metonunda alınan id'yi buraya gönderiyor.
     */
    public void aracDBArama(Long id){
        Optional<Arac> arac = aracRepository.findById(id);
        if (arac.isPresent()){
            System.out.println("");
            System.out.println("**********************");
            System.out.println("Araç markası: " + arac.get().getMarka());
            System.out.println("Araç modeli: " + arac.get().getModel());
            System.out.println("Araç yılı: " + arac.get().getYil());
            System.out.println("**********************");
            System.out.println("");
        }
        else {
            System.out.println("Girdiğiniz id'de araç bulunmuyor. ");
        }
    }

    /**
     * kirada olan araçları repositoryde listeye alınıyor ve burda yazdırılıyor.
     */
    public void kiradaOlanAraclariYazdir(){
        List<Arac> araclar = aracRepository.kiradaOlanAraclariListele();
        if (!araclar.isEmpty()){
            System.out.println("*** KIRADA OLAN ARACLAR ***");
            araclar.forEach(arac -> {
                System.out.println("**********************");
                System.out.println("Araç markası: " + arac.getMarka());
                System.out.println("Araç modeli: " + arac.getModel());
                System.out.println("Araç yılı: " + arac.getYil());
                System.out.println("**********************");
                System.out.println("");
            });
        }
    }
    /**
     * boşta olan araçları repositoryde listeye alınıyor ve burda yazdırılıyor.
     */
    public void bostaOlanAraclariYazdir(){
        List<Arac> araclar = aracRepository.bostaOlanAraclariListele();
        if (!araclar.isEmpty()){
            System.out.println("*** BOSTA OLAN ARACLAR ***");
            araclar.forEach(arac -> {
                System.out.println("**********************");
                System.out.println("Araç markası: " + arac.getMarka());
                System.out.println("Araç modeli: " + arac.getModel());
                System.out.println("Araç yılı: " + arac.getYil());
                System.out.println("**********************");
                System.out.println("");
            });
        }
    }
}
