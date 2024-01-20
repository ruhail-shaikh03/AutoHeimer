package com.example.sdaproject;

import javafx.collections.ObservableList;

import java.io.IOException;

public class PaymentOOP {
    static int ad_id;
    static int package_id;

    PaymentOOP(int i, int j) throws IOException {
        ad_id=i;
        package_id=j;
        AutoheimerUI.payment();
    }
    PaymentOOP() {
    }
    public void makePayment(ObservableList<String>o){
        int amount=0;
        int pack = package_id;
        if (pack == 1)
            amount = 4000;
        else if (pack == 2)
            amount = 5000;
        else if (pack == 3)
            amount = 8000;

        PaymentDB p = new PaymentDB();
        System.out.println(package_id);
        p.makePayment(o,ad_id,amount);
    }


}
