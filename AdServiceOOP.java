package com.example.sdaproject;

public class AdServiceOOP {
    static int id;
    private int ad_id;
    private int adv_id;
    AdServiceOOP(){id=0;}
    AdServiceOOP(int i){
        id=i;
    }


    public myUse getListings(int i){
        id=i;
        AdServiceDB a = new AdServiceDB();
        return a.getListings(i);
    }
    public myUse getPackages(){
        AdServiceDB a = new AdServiceDB();
        return a.DisplayAvailablePackages();
    }
    public void updateAd(int i,int ii){
        AdServiceDB a = new AdServiceDB();
        ad_id=i;
        System.out.println(ii);
        System.out.println(ad_id);
        a.updateAdvert(ad_id,ii);
    }
    public void updateAdvertDB(int i,int j,int k){
        AdServiceDB a = new AdServiceDB();
        a.updateAdvertData(i,j,k);
    }


}
