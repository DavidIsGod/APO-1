package model;


public abstract class BibliographicProduct {

    private String id;
    private String name;
    private int numberPages;
    private String publishDate;
    private Double sellPrice;
    private int pagesAcum;
    private String Url = "//Https.";
    private int amountSoldUnits;
    private int[] [] library = new int [5] [5];


    public BibliographicProduct(String id,String name,int numberPages,String publishDate,double sellPrice,String url) {
                                         
        this.id = id;
        this.name = name;
        this.numberPages = numberPages;
        this.publishDate = publishDate;
        this.sellPrice = sellPrice;
        this.pagesAcum = pagesAcum;
    }


    

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getNumberPages() {
        return numberPages;
    }


    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }


    public String getPublishDate() {
        return publishDate;
    }


    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public Double getSellPrice() {
        return sellPrice;
    }


    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }


    public int getPagesAcum() {
        return pagesAcum;
    }


    public void setPagesAcum(int pagesAcum) {
        this.pagesAcum = pagesAcum;
    }


    public String getUrl() {
        return Url;
    }


    public void setUrl(String url) {
        Url = url;
    }


    public int getAmountSoldUnits() {
        return amountSoldUnits;
    }


    public void setAmountSoldUnits(int amountSoldUnits) {
        this.amountSoldUnits = amountSoldUnits;
    }


   
}