package org.ismetg.controller;

import org.ismetg.service.KiralamaService;
import org.ismetg.utility.InputUtil;

public class KiralamaController {
    KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }

    /**
     * İdleri burda kullanıcıdan alıp kiralamaService de kontrolü yapılıyor.
     * DB'ye ekleniyor.
     */
    public void kiralamaYap(){
        Long kisiId = InputUtil.getLongValue("kiralayacak kişinin id'sini girin...: ");
        Long aracId = InputUtil.getLongValue("kiralanacak aracın id'sini girin...: ");
        double ucret = InputUtil.getDoubleValue("ücreti giriniz...: ");
        kiralamaService.DByeKiralamaEkle(aracId , kisiId , ucret);
    }
}
