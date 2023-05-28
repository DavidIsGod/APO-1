package model;

import java.util.ArrayList;
import java.util.Calendar;


public class Standard extends User{

    private Book[] StandardBook = new Book[5];
    private Magazine[] StandardMagazine = new Magazine[2];
    private ArrayList <Ticket> listOfTickets;

    public ArrayList<Ticket> getListOfTickets() {
        return listOfTickets;
    }

    public Standard(String name, String id, Calendar vinculationDate) {
        super(name, id, vinculationDate);

        this.listOfTickets = new ArrayList<>();
        StandardBook = new Book[5];
        StandardMagazine = new Magazine[2];
    }


    public void setListOfTickets(ArrayList<Ticket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }

    public BibliographicProduct[] getStandardMagazine() {
        return StandardMagazine;
    }



    public void setStandardMagazine(BibliographicProduct[] standardMagazine) {
        StandardMagazine = (Magazine[]) standardMagazine;
    }



    public BibliographicProduct[] getStandardBook() {
        return StandardBook;
    }



    public void setStandardBook(BibliographicProduct[] standardBook) {
        StandardBook = (Book[]) standardBook;
    }

   
    @Override
    public boolean saveTicket(Ticket tc) {
        
        return listOfTickets.add(tc);
    }

    public boolean verifyBook() {

        int counterBook = 0;
        for (int i = 0; i < StandardBook.length; i++) {
            if (counterBook < 5) {
            
                return true;
        
            }
        
        }
        return false;
    }



    public boolean verifyMagazine() {

        int counterMagazine = 0;
        for (int i = 0; i < StandardMagazine.length; i++) {
            if (counterMagazine < 2) {
                return true;
            }
         
        }

    
        return false;
    }


    @Override
    public boolean buyBook(BibliographicProduct bp) {
        if (verifyBook()) {
            for (int i = 0; i < StandardBook.length; i++) {
                if (StandardMagazine[i] == null) {
                    Book copy = new Book((Book) bp);
                    StandardBook[i] = (copy);
                    return true; 
                }
            }
        }
        return false;
    }

    public int countSubs() {
        int counter = 0;
        for (int i = 0; i < StandardMagazine.length; i++) {
            if (StandardMagazine[i] != null) {
                counter++;
            }
        }
        return counter;
    }


    @Override
    public boolean buyMagazine(BibliographicProduct bp) {
        
        if (verifyMagazine()) {
            for (int i = 0; i < StandardMagazine.length; i++) {
                if (StandardMagazine[i] == null) {
                    StandardMagazine[i] = ((Magazine)bp); 
                    return true;
                }
            }
        }

       return false;

    }

    @Override
    public String showBookList() {

        String BooksList = "";

        for(int i = 0; i < StandardBook.length; i++){
        
            BooksList+= (i +1)+ ". " + StandardBook[i].getName() + "\n";
            
        }
        return BooksList;
    }
    

    @Override
    public String showMagList() {

        String MagsList = "";

        for(int i = 0; i < StandardMagazine.length; i++){
            if (StandardMagazine[i] != null) {

                MagsList+= (i +1)+ ". " + StandardMagazine[i].getName() + "\n";
            }
           
            
        }
        return MagsList;
      
    }

    public boolean cancelSub(int idMag) {
        StandardMagazine[idMag-1] = null;
        return true;
    }

    public int addPagesInBook(){

        int bookAcumulRead = 0;

        for (int i = 0; i < StandardBook.length; i++) {
            if(StandardBook[i] instanceof Book){
                bookAcumulRead += StandardBook[i].getPagesAcum();
            }
        }
        return bookAcumulRead;
    }

    public int addPagesInMag(){

        int magAcumulRead = 0;

        for (int i = 0; i < StandardBook.length; i++) {
            if(StandardMagazine[i] instanceof Magazine){
                magAcumulRead += StandardBook[i].getPagesAcum();
            }
        }
        return magAcumulRead;
    }

   
    @Override
    public String getProducts() {
       String msg = "";

       return msg;
    }
  
    public void insertionSortBook(){
            
            for (int rojo = 1; rojo < StandardBook.length; rojo++){
                for (int verde = 0; verde < rojo; verde++) {
                    if(StandardBook[rojo] instanceof Book){
                    if (StandardBook[rojo].getPublishDate().compareTo(StandardBook[verde].getPublishDate()) < 0) {
                        Book temp = StandardBook[rojo];
                        StandardBook[rojo] = StandardBook[verde];
                        StandardBook[verde] = temp;
                        break;
                    }
                }
            }
        }
    }

    public void insertionSortMag(){
        
        for (int rojo = 1; rojo < StandardMagazine.length; rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (StandardMagazine[rojo].getPublishDate().compareTo(StandardMagazine[verde].getPublishDate()) < 0) {
                    Magazine temp = StandardMagazine[rojo];
                    StandardMagazine[rojo] = StandardMagazine[verde];
                    StandardMagazine[verde] = temp;
                    break;
                }
            }
        }
    }
}
