package org.ismetg.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.ismetg.service.AracService;
import org.ismetg.utility.InputUtil;

public class AracController {
    AracService aracService;

    public AracController() {
        this.aracService = new AracService();
    }

    /**
     * Kullanıcıdan verileri alıyoruz.
     * aracService içinde veritabanına kaydediyoruz.
     */
    public void aracEkle(){

        System.out.println("*** ARAC EKLE ***");
        System.out.println("");
        String marka = InputUtil.getStringValue("Arac markasi...: ");
        String model = InputUtil.getStringValue("Arac modeli...: ");
        Integer yil = InputUtil.getIntegerValue("Arac yılı...: ");
        aracService.aracDBIsle(marka , model ,yil );
    }

    /**
     * burda aramak için kullanıcıdan id alıyoruz.
     * o id ile aracService içindeki aracDBArama içinde id arıyor ve yazdırıyor.
     */
    public void aracArama(){
        Long id = InputUtil.getLongValue("Aramak istediğiniz aracın id'sini giriniz...: ");
        aracService.aracDBArama(id);
    }


}
