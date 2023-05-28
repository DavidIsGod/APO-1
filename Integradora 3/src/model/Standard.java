package model;

import java.util.ArrayList;
import java.util.Calendar;


public class Standard extends User{

    private BibliographicProduct[] StandardProducts = new BibliographicProduct[7];
  
    public BibliographicProduct[] getStandardProducts() {
        return StandardProducts;
    }

    public void setStandardProducts(BibliographicProduct[] standardProducts) {
        StandardProducts = standardProducts;
    }

    private ArrayList <Ticket> listOfTickets;

    public ArrayList<Ticket> getListOfTickets() {
        return listOfTickets;
    }

    public Standard(String name, String id, Calendar vinculationDate) {
        super(name, id, vinculationDate);

        this.listOfTickets = new ArrayList<>();
        StandardProducts = new BibliographicProduct[7];
    }


    public void setListOfTickets(ArrayList<Ticket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }

    @Override
    public boolean saveTicket(Ticket tc) {
        
        return listOfTickets.add(tc);
    }

    public boolean verifyBook() {

        int counterBook = 0;
        for (int i = 0; i < StandardProducts.length; i++) {
            if (counterBook < 5) {
            
                return true;
        
            }
        
        }
        return false;
    }



    public boolean verifyMagazine() {

        int counterMagazine = 0;
        for (int i = 0; i < StandardProducts.length; i++) {
            if (counterMagazine < 2) {
                return true;
            }
         
        }

    
        return false;
    }


    @Override
    public boolean buyBook(BibliographicProduct bp) {
        if (verifyBook()) {
            for (int i = 0; i < StandardProducts.length; i++) {
                if (StandardProducts[i] == null) {
                    Book copy = new Book((Book) bp);
                    StandardProducts[i] = (copy);
                    return true; 
                }
            }
        }
        return false;
    }

    public int countSubs() {
        int counter = 0;
        for (int i = 0; i < StandardProducts.length; i++) {
            if (StandardProducts[i] != null) {
                counter++;
            }
        }
        return counter;
    }


    @Override
    public boolean buyMagazine(BibliographicProduct bp) {
        
            if (verifyMagazine()) {
                for (int i = 0; i < StandardProducts.length; i++) {
                    if (StandardProducts[i] == null) {
                        if(StandardProducts[i] instanceof Magazine){
                            Magazine copy = new Magazine((Magazine) bp);
                            StandardProducts[i] = (copy);
                        return true;
                    }
                }
            }
        }

       return false;

    }

    @Override
    public String showBookList() {

        String BooksList = "";

        for(int i = 0; i < StandardProducts.length; i++){
        
            BooksList+= (i +1)+ ". " + StandardProducts[i].getName() + "\n";
            
        }
        return BooksList;
    }
    

    @Override
    public String showMagList() {

        String MagsList = "";

        for(int i = 0; i < StandardProducts.length; i++){
            if (StandardProducts[i] != null) {
                if(StandardProducts[i] instanceof Magazine){

                    MagsList+= (i +1)+ ". " + StandardProducts[i].getName() + "\n";
                }
            
            }
        }
        return MagsList;
        
    }

    public boolean cancelSub(int idMag) {
        StandardProducts[idMag-1] = null;
        return true;
    }

    public int addPagesInBook(){

        int bookAcumulRead = 0;

        for (int i = 0; i < StandardProducts.length; i++) {
            if(StandardProducts[i] instanceof Book){
                bookAcumulRead += StandardProducts[i].getPagesAcum();
            }
        }
        return bookAcumulRead;
    }

    public int addPagesInMag(){

        int magAcumulRead = 0;

        for (int i = 0; i < StandardProducts.length; i++) {
            if(StandardProducts[i] instanceof Magazine){
                magAcumulRead += StandardProducts[i].getPagesAcum();
            }
        }
        return magAcumulRead;
    }

   
    @Override
    public String getProducts() {
       String msg = "";

       return msg;
    }
  
    public void insertionSort(){
            
            for (int rojo = 1; rojo < StandardProducts.length; rojo++){
                for (int verde = 0; verde < rojo; verde++) {
                    if(StandardProducts[rojo] instanceof Book){
                    if (StandardProducts[rojo].getPublishDate().compareTo(StandardProducts[verde].getPublishDate()) < 0) {
                        BibliographicProduct temp = StandardProducts[rojo];
                        StandardProducts[rojo] = StandardProducts[verde];
                        StandardProducts[verde] = temp;
                        break;
                    }
                }
            }
        }
    }

}
