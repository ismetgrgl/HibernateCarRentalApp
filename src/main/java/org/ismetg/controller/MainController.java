package org.ismetg.controller;

import org.ismetg.service.AracService;
import org.ismetg.utility.InputUtil;

import java.util.InputMismatchException;

public class MainController {
    static AracController aracController = new AracController();
    static KisiController kisiController = new KisiController();
    static KiralamaController kiralamaController  =new KiralamaController();
    public void anaMenu(){
        while (true) {
            System.out.println("********************************************");
            System.out.println("********* ARAC KIRALAMA UYGULAMASI *********");
            System.out.println("********************************************");
            System.out.println(" ");
            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Arama");
            System.out.println("3- Kisi Ekleme");
            System.out.println("4- Kiralama");
            System.out.println("5- Rapor");
            System.out.println("0- ÇIKIS YAP");
            Integer secim;
            try {
                secim = InputUtil.getIntegerValue("Seçiniz...: ");
            }catch (InputMismatchException e){
                throw new RuntimeException("boş giremezsiniz");
            }
            switch (secim) {
                case 1:
                    aracController.aracEkle();
                    break;
                case 2:
                    aracController.aracArama();
                    break;
                case 3:
                    kisiController.KisiEKle();
                    break;
                case 4:
                    kiralamaController.kiralamaYap();
                    break;
                case 5:
                    raporIslemleri();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    public void raporIslemleri(){
        while (true) {

            System.out.println("********* Rapor Islemleri *********");

            System.out.println(" ");
            System.out.println("1- Şu anda kirada olan araclari listele");
            System.out.println("2- Şu anda bosta olan araclari listele");
            System.out.println("3- Herhangi bir müsterinin kiraladigi araclari listele");
            System.out.println("0- RAPOR MENUSUNDEN ÇIKIS YAP");
            Integer secim;
            try {
                secim = InputUtil.getIntegerValue("Seçiniz...: ");
            }catch (InputMismatchException e){
                throw new RuntimeException("boş giremezsiniz");
            }
            switch (secim) {
                case 1:
                    aracController.aracService.kiradaOlanAraclariYazdir();
                    break;
                case 2:
                    aracController.aracService.bostaOlanAraclariYazdir();
                    break;
                case 3:
                    kisiController.idyeGoreMusterininKiraladigiAraclar();
                    break;
                case 0:
                    return;
            }
        }
    }

}
