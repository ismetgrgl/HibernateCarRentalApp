package org.ismetg.controller;

import org.ismetg.service.KisiService;
import org.ismetg.utility.InputUtil;

public class KisiController {
    KisiService kisiService;
    public KisiController() {
        this.kisiService = new KisiService();
    }

    /**
     * müşteri bilgileri alınıp service de DB'ye işleniyor.
     */
    public void KisiEKle(){
        System.out.println("\n*** MUSTERİ EKLE ***\n");
        String ad = InputUtil.getStringValue("Adı...: ");
        String soyad = InputUtil.getStringValue("Soyadı...: ");
        String telefon = InputUtil.getStringValue("Telefon No...: ");
        String email = InputUtil.getStringValue("Email...: ");
        String tcKimlikNo = InputUtil.getStringValue("TcKimlikNo...: ");
        String konum = InputUtil.getStringValue("konum...: ");
        kisiService.kisiDBIsle(ad,soyad,telefon,email,tcKimlikNo,konum);
    }

    /**
     * müşterinin kiraladığı arabaları bulmak için müşteri idsi alınıyor
     * servicede idyegorearaclaribul metodu buluyor.
     */
    public void idyeGoreMusterininKiraladigiAraclar(){
        Long kisiId = InputUtil.getLongValue("sorgulamak istediğiniz müşterinin id'sini giriniz");
        kisiService.idyeGoreAraclariBul(kisiId);
    }
}
