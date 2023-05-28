package model;

import java.util.ArrayList;
import java.util.Calendar;


public class Premium extends User {
  
    private ArrayList<Ticket> listoFTickets;
    private ArrayList<BibliographicProduct>listOfProducts;
  
  
    public Premium(String name, String id, Calendar vinculationDate) {
        super(name, id, vinculationDate);

        this.listoFTickets = new ArrayList<>();
        this.listOfProducts = new ArrayList<>();
        
    }

    public ArrayList<Ticket> getListoFTickets() {
        return listoFTickets;
    }


    public void setListoFTickets(ArrayList<Ticket> listoFTickets) {
        this.listoFTickets = listoFTickets;
    }


    public String showBookList(){

        String BooksList = "";

        for(int i = 0; i< listOfProducts.size(); i++){
        
            if (listOfProducts.get(i) instanceof Book) {
            
                BooksList+= (i +1)+ ". " + listOfProducts.get(i).getName() + "\n";
            }
        }
        return BooksList;
    }

    public String showMagList(){

        String BooksList = "";

        for(int i = 0; i< listOfProducts.size(); i++){
        
            if (listOfProducts.get(i) instanceof Magazine) {
            
                BooksList+= (i +1)+ ". " + listOfProducts.get(i).getName() + "\n";
            }
        }
        return BooksList;
    }

    public boolean cancelSub(int idMag) {
        if(listOfProducts.get(idMag) instanceof Magazine){
            listOfProducts.remove(idMag-1);
            return true;
        }
       return false;
    }


    @Override
    public boolean buyBook(BibliographicProduct bp) {
        Book copy = new Book((Book) bp);
        return listOfProducts.add(copy);
    }



    @Override
    public boolean saveTicket(Ticket tc) {
        
        return listoFTickets.add(tc);
    }



    @Override
    public boolean buyMagazine(BibliographicProduct bp) {
       return listOfProducts.add((Magazine)bp);
    }

    public int addPages(){

        int AcumulRead = 0;
 
        for (int i = 0; i < listOfProducts.size(); i++) {
            if(listOfProducts.get(i) instanceof Book){
                AcumulRead += listOfProducts.get(i).getPagesAcum();
            }
            
        }
        return AcumulRead;
    }

 
    public String toStringPremium(){

        String msg = "";
        User user;

        msg += "\nEl nombre de este Usuario es:  \nEl id de este usuario es: \nLa fecha de vinculación del Usuario es: ";


        return msg;
    }

    @Override

    public String getProducts(){
        String msg = "[ ___ ][  0 ][  1 ][  2 ][  3 ][  4 ]";
        for (int i = 0; i < getListAllLibraries().size(); i++) {
            for (int j = 0; j < getListAllLibraries().get(i).length; j++) {
                for (int j2 = 0; j2 < getListAllLibraries().get(i).length; j2++) {
                    if (getListAllLibraries().get(i)[j][j2] != null) {
                        msg += "[ " + getListAllLibraries().get(i)[j][j2].getId() + " ]";
                    } else {
                        msg += "[ _ ]";
                    }
                    
                }
                msg += "\n";
            }
            msg += "\n";
        }
        
        return msg;
    }

    /*  public String getProducts() {
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
    }/* */

    public void initMatrix() {
        insertionSort();
        listOfProducts.forEach((bibliographicProduct) ->{
            System.out.println(bibliographicProduct.getPublishDate());
        });
        ArrayList<BibliographicProduct[][]> temp = new ArrayList<>((int)Math.ceil(listOfProducts.size()/25));
        int cont = 0;
        for (int h = 0; h < temp.size(); h++) {
            BibliographicProduct[][] matrix = new BibliographicProduct[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    matrix[i][j] = listOfProducts.get(cont);
                    cont++;
                }
            }
            temp.add(matrix);
        }

        setListAllLibraries(temp);
    }
  
    public void insertionSort() { 
        
        for (int rojo = 1; rojo <listOfProducts.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listOfProducts.get(rojo).getPublishDate().compareTo(listOfProducts.get(verde).getPublishDate()) < 0) {
                    listOfProducts.add(verde, listOfProducts.remove(rojo));
                    break;
                }
            }
        }
    }
}

  
