package model;

import java.util.ArrayList;
import java.util.Calendar;


public class Premium extends User {
  
    private ArrayList<Book> listOfBooks;
    private ArrayList<Ticket> listoFTickets;
    private ArrayList<Magazine>listOfMagazines;
  
  
    public Premium(String name, String id, Calendar vinculationDate) {
        super(name, id, vinculationDate);

        this.listOfBooks = new ArrayList<Book>();
        this.listOfMagazines = new ArrayList<Magazine>();
        this.listoFTickets = new ArrayList<>();
        
    }



    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }


    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }


    public ArrayList<Ticket> getListoFTickets() {
        return listoFTickets;
    }


    public void setListoFTickets(ArrayList<Ticket> listoFTickets) {
        this.listoFTickets = listoFTickets;
    }


    public ArrayList<Magazine> getListOfMagazines() {
        return listOfMagazines;
    }


    public void setListOfMagazines(ArrayList<Magazine> listOfMagazines) {
        this.listOfMagazines = listOfMagazines;
    }

    public String showBookList(){

        String BooksList = "";

        for(int i = 0; i< listOfBooks.size(); i++){
        
            if (listOfBooks.get(i) instanceof Book) {
            
                BooksList+= (i +1)+ ". " + listOfBooks.get(i).getName() + "\n";
            }
        }
        return BooksList;
    }

    public String showMagList(){

        String BooksList = "";

        for(int i = 0; i< listOfMagazines.size(); i++){
        
            if (listOfMagazines.get(i) instanceof Magazine) {
            
                BooksList+= (i +1)+ ". " + listOfMagazines.get(i).getName() + "\n";
            }
        }
        return BooksList;
    }

    public boolean cancelSub(int idMag) {
        listOfMagazines.remove(idMag-1);
        return true;
    }


    @Override
    public boolean buyBook(BibliographicProduct bp) {
        Book copy = new Book((Book) bp);
        return listOfBooks.add(copy);
    }



    @Override
    public boolean saveTicket(Ticket tc) {
        
        return listoFTickets.add(tc);
    }



    @Override
    public boolean buyMagazine(BibliographicProduct bp) {
       return listOfMagazines.add((Magazine)bp);
    }

    public int addPagesInBook(){

        int bookAcumulRead = 0;
 
        for (int i = 0; i < listOfBooks.size(); i++) {
            if(listOfBooks.get(i) instanceof Book){
                bookAcumulRead += listOfBooks.get(i).getPagesAcum();
            }
            
        }
        return bookAcumulRead;
    }

    public int addPagesInMagazine(){
        int magAcumulRead = 0;

        for (int i = 0; i < listOfMagazines.size(); i++) {
            if(listOfMagazines.get(i) instanceof Magazine){
                magAcumulRead += listOfMagazines.get(i).getPagesAcum();
            }
        }
        return magAcumulRead;
    }

    public String toStringPremium(){

        String msg = "";
        User user;

        msg += "\nEl nombre de este Usuario es:  \nEl id de este usuario es: \nLa fecha de vinculación del Usuario es: ";


        return msg;
    }

    @Override
    public String getProducts() {
                String msg = "[ ___ ][  0 ][  1 ][  2 ][  3 ][  4 ]";
                for (int i = 0; i < getListAllLibraries().size(); i++) {
                    for (int j = 0; j < getListAllLibraries().get(i).length; j++) {
                        if(getListAllLibraries().get(i)[j] != null){
                        msg+= "[ " +j+ "]";
                        for (int j2 = 0; j2 < getListAllLibraries().get(i).length; j2++) {
                            if (getListAllLibraries().get(i)[j][j2] != null) {
                                msg += "[ " + getListAllLibraries().get(i)[j][j2].getId() + " ]";
                            } else {
                                msg += "[ _ ]";
                            }
                            
                        }
                        msg += "\n";
                    }
                }
                msg += "\n";
            }
        
        
        return msg;
    }

  
    public void initMatrixBook() {
        insertionSortBooks();
        insertionSortBooks();
        insertionSortMagazines();
        ArrayList<BibliographicProduct[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < listOfBooks.size(); h++) {
            BibliographicProduct[][] matrix = new BibliographicProduct[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    matrix[i][j] = listOfBooks.get(cont);
                    cont++;
                }
            }
            temp.add(matrix);
        }

        setListAllLibraries(temp);
    
    }
    
    public void insertionSortBooks() { 
        
        for (int rojo = 1; rojo <listOfBooks.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listOfBooks.get(rojo).getPublishDate().compareTo(listOfBooks.get(verde).getPublishDate()) < 0) {
                    listOfBooks.add(verde, listOfBooks.remove(rojo));
                    break;
                }
            }
        }
    }

    public void insertionSortMagazines() { 
        
        for (int rojo = 1; rojo <listOfMagazines.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listOfMagazines.get(rojo).getPublishDate().compareTo(listOfMagazines.get(verde).getPublishDate()) < 0) {
                    listOfMagazines.add(verde, listOfMagazines.remove(rojo));
                    break;
                }
            }
        }
    }
}
