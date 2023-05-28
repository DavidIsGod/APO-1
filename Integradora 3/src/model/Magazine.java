package model;

import java.util.Date;

public class Magazine extends BibliographicProduct{

    private String periodicity;
    private int activeSubscrip;
    private MagazineCategory category;



    public Magazine(String id, String name, int numberPages, String dateMagazine, double sellPrice, String url,String periodicity,MagazineCategory category) {
        super(id, name, numberPages, dateMagazine, sellPrice, url);
        
        this.periodicity = periodicity;
        this.activeSubscrip = activeSubscrip;
        this.category = category;
        
    }



    public String getPeriodicity() {
        return periodicity;
    }



    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }



    public int getActiveSubscrip() {
        return activeSubscrip;
    }



    public void setActiveSubscrip(int activeSubscrip) {
        this.activeSubscrip = activeSubscrip;
    }



    public MagazineCategory getCategory() {
        return category;
    }



    public void   setCategory(MagazineCategory category) {
        this.category = category;
    }
    

}
