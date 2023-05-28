package model;

import java.util.ArrayList;
import java.util.Calendar;


public abstract class User {
    private String name;
    private String id;
    private Calendar vinculationDate;
    private ArrayList<BibliographicProduct[][]>listAllLibraries;

    
    public ArrayList<BibliographicProduct[][]> getListAllLibraries() {
        return listAllLibraries;
    }

    public void setListAllLibraries(ArrayList<BibliographicProduct[][]> listAllLibraries) {
        this.listAllLibraries = listAllLibraries;
    }



    public User(String name, String id, Calendar vinculationDate) {
        this.name = name;
        this.id = id;
        this.vinculationDate = vinculationDate;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public Calendar getVinculationDate() {
        return vinculationDate;
    }

    public abstract boolean buyBook(BibliographicProduct bp);

    public abstract boolean buyMagazine(BibliographicProduct bp);

    public abstract boolean saveTicket(Ticket tc);

    public abstract boolean cancelSub(int idMag);



    public void setVinculationDate(Calendar vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    

    /**
     * @return
     */
    public String toStringStandard(){

        String msg = "";

        msg += "\n El nombre de este usario es: " +name+ "\nEl id de este usuario es: " +id+ "\nLa fecha de vinculacion de este usario es: " +vinculationDate;

        return msg;
    }

    public abstract String showBookList();

    public abstract String showMagList();

    public abstract String getProducts();
    
}


