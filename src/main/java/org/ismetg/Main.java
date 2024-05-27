package org.ismetg;

import org.ismetg.controller.MainController;
import org.ismetg.utility.DummyData;

public class Main {
    public static void main(String[] args) {

        //DummyData dummyData = new DummyData();
        //dummyData.dataEkle();

        MainController mainController = new MainController();
        mainController.anaMenu();
    }
}