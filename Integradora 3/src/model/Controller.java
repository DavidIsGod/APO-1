package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Controller {
    
    private ArrayList<User> listOfUsers;
    private ArrayList<BibliographicProduct> listOfBibliographicProducts;


    public Controller(){

    listOfUsers = new ArrayList<>();
    listOfBibliographicProducts = new ArrayList<>();
    testCasesBiblioProducts();
    testCasesUsers();
    }   

    public void testCasesBiblioProducts() {

      listOfBibliographicProducts.add(0, new Book("A2F", "Spider - Man", 34, "12/02/2022",320000 , "SpiderMan.net","nice Book", BookType.FANTASY));
        listOfBibliographicProducts.add(1, new Magazine("B9D", "The Last Of Us", 12, "06/07/2023", 200000, "TheLastOfUs.com", "Weekly", MagazineCategory.VARIETIES));
    }
       
    public void testCasesUsers(){

        listOfUsers.add(0, new Premium("David", "A00399865", Calendar.getInstance()));
        listOfUsers.add(1, new Standard("Juan", "A00598721", Calendar.getInstance()));
    }
    

    public boolean regMagazine(String id,String name,int numberPages,String publishDate,double sellPrice,String url,String periodicity,int category){
      
        MagazineCategory type = MagazineCategory.VARIETIES;
        switch(category){

            case 1:
            type = MagazineCategory.VARIETIES;
            break;

            case 2:
            type = MagazineCategory.DESIGN;
            break;

            case 3:
            type = MagazineCategory.SCIENTIFIC;
            break;
        }

        Date dateMagazine = null;

        try{

            dateMagazine = new SimpleDateFormat("dd/MM/yyyy").parse(publishDate);
        } catch (ParseException a) {

            a.printStackTrace();
        }
        Magazine newMagazine = new Magazine(id, name, numberPages, publishDate, sellPrice, url, periodicity,type);
        return listOfBibliographicProducts.add(newMagazine);
    }

    public String selectUser (int positionUser){

        String msg = "";

        if(listOfUsers.get(positionUser)instanceof Standard ){

            msg += "El usuario es regular";
        }else if(listOfUsers.get(positionUser)instanceof Premium){

            msg += "El usuario es Premium";
        }

        return msg;
    }

    public boolean cancelSub(int idMag,int idUser){

        if(listOfUsers.get(idUser).cancelSub(idMag)){
            return true;
        }
       return false;
    }
    
    public String readingSession(int idUser,int idBook){

        String msg = ""; 

      



        return msg;
    }

    public boolean sellBook(int idUser, int idBook){

        if(idBook >= listOfBibliographicProducts.size() || idUser >= listOfUsers.size()){
            return false;
        }

        Ticket tc = new Ticket(Calendar.getInstance(), listOfBibliographicProducts.get(idBook-1).getSellPrice());

        if (listOfBibliographicProducts.get(idBook-1) instanceof Book) {
            
            listOfUsers.get(idUser-1).saveTicket(tc);
            printTc(tc); 
            return listOfUsers.get(idUser-1).buyBook(listOfBibliographicProducts.get(idBook-1));
            
            
        }  

        return false;
       
    }

    public boolean sellMagazine(int idUser, int idMagazine) {

        Ticket tc = new Ticket(Calendar.getInstance(), listOfBibliographicProducts.get(idMagazine-1).getSellPrice());

        if (listOfBibliographicProducts.get(idMagazine-1) instanceof Magazine){

            listOfUsers.get(idUser-1).saveTicket(tc);
            printTc(tc); 
            return listOfUsers.get(idUser-1).buyMagazine(listOfBibliographicProducts.get(idMagazine-1));
           
        }

        return false;
    }

    public String showBookListOfUser(int idUser) {
        return listOfUsers.get(idUser).showBookList();
    }

    public String showMagazinesListOfUser(int idUser){
        return listOfUsers.get(idUser).showMagList();
    }
    

    public String showBookList(){

        String BooksList = "";

        for(int i = 0; i< listOfBibliographicProducts.size(); i++){
        
            if (listOfBibliographicProducts.get(i) instanceof Book) {
            
                BooksList+= (i +1)+ ". " + listOfBibliographicProducts.get(i).getName() + "\n";
            }
        }
        return BooksList;
    }


    public String showMagazinesList(){

        String MagazinesList = "";

        for(int i = 0; i< listOfBibliographicProducts.size(); i++){

            if (listOfBibliographicProducts.get(i) instanceof Magazine){

                MagazinesList+= (i + 1)+ ". " +listOfBibliographicProducts.get(i).getName() + "\n";
            }
        }
        return MagazinesList;
    }

    public String showUsersList() {

        String usersList = "";
        for(int i = 0; i<listOfUsers.size(); i++){
            
            usersList += (i+1)+ ". " + listOfUsers.get(i).getName() + "\n";
        }
        return  usersList;
    }

    public ArrayList<User> getUsers(){

        return listOfUsers;
    }

    public boolean modifyMagazines(int option,int option2,String newMagazineId, String newMagazineName,int newMagazineNumberPages,String newdate,int newMagazineType, String newMagazineURl,double newSellPriceMagazine, String newPeriodicity){

        
        MagazineCategory magType = MagazineCategory.VARIETIES;
        switch(newMagazineType){

            case 1:
            magType = MagazineCategory.VARIETIES;
            break;

            case 2:
            magType = MagazineCategory.DESIGN;
            break;

            case 3:
            magType = MagazineCategory.SCIENTIFIC;
            break;
        }
        Date dateMagazine = null;

        try{

            dateMagazine = new SimpleDateFormat("dd/MM/yyyy").parse(newdate);
        } catch (ParseException a) {

            a.printStackTrace();
        }

            BibliographicProduct magazine = listOfBibliographicProducts.get(option);
              if(magazine instanceof Magazine){
                magazine.setId(newMagazineId);
                magazine.setName(newMagazineName);
                magazine.setNumberPages(newMagazineNumberPages);
                ((Magazine) magazine).setPeriodicity(newPeriodicity);
                ((Magazine)magazine).setCategory(magType);
                magazine.setUrl(newMagazineURl);  
                magazine.setSellPrice(newSellPriceMagazine);  
               return true;
             }
                  
              return false;      
       
    }


    public boolean modifyBooks(int option2,String newid,String newName,int newNumberPages,String newReview,String newDate,int newGenderBook,String newURL,double newSellPrice){

        BookType type = BookType.FANTASY;

        switch (newGenderBook) {
            case 1:
                type = BookType.SCIENCE_FICTION; 
                break;
            case 2:
                type = BookType.FANTASY;
            break;

            case 3:
                type = BookType.HISTORIC_NOVEL;
            break;
            
        }

        
        Date dateBook = null;

        try{

            dateBook = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
        } catch (ParseException a) {

            a.printStackTrace();
        }

       BibliographicProduct book =  listOfBibliographicProducts.get(option2);

        book.setId(newid);
        book.setName(newName);
        book.setNumberPages(newNumberPages);
        ((Book) book).setReview(newReview);
        book.setPublishDate(newDate);
        ((Book) book).setBookType(type);
        book.setUrl(newURL);
        book.setSellPrice(newSellPrice);
        return false;
    }

   
    public boolean deleteBooks(int bookPosition) {
        if(bookPosition>listOfBibliographicProducts.size()){
            return false;
        }
        listOfBibliographicProducts.remove(bookPosition);
 
        return true;
    }

    public boolean deleteMagazines(int magazinePosition){
        if(magazinePosition>listOfBibliographicProducts.size()){
            return false;
        }
        listOfBibliographicProducts.remove(magazinePosition);
        return true;
    }


    public boolean registerUser(String name, String id,  int typeUser){
        User newUser = null;
        Calendar creationDate = Calendar.getInstance();

        if (typeUser == 1) {
            newUser = new Standard(name, id, creationDate);
        } else if (typeUser == 2) {
            newUser = new Premium(name, id, creationDate);
        }
        
       return listOfUsers.add(newUser);
    }

    

    public boolean regBook(String id, String name, int numberPages, String review, String date, int bookTypeId, String url, int sellPrice,int amountSoldUnits,int pagesAcum) {

        BookType booktype = BookType.SCIENCE_FICTION;

        switch (bookTypeId){

            case 1:
            booktype = BookType.SCIENCE_FICTION;
            break;

            case 2:
            booktype = BookType.FANTASY;
            break;

            case 3:
            booktype = BookType.HISTORIC_NOVEL;
            break;
        }


        Date dateBook = null;
        try {
            dateBook = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        Book newBook = new Book(id, name, numberPages, date, sellPrice, url, review, booktype);

        return listOfBibliographicProducts.add(newBook);

    
    }

    public void printTc(Ticket tc) {

        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formattedDate.format(tc.getDate().getTime());
        double amountPaid = tc.getPurchaseValue();

        System.out.println("----------------------------");
        System.out.println("¡Welcome To Your Ticket!");
        System.out.println("The date of the Transaction Was: " +date);
        System.out.println("The Amount Paid Was: " +amountPaid);
        System.out.println("-------------------------------------------");

    }

    public String myLibrary(int idUser){
        String msg = "";

        msg += listOfUsers.get(idUser).getProducts();
        return msg;
    }

    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public ArrayList<BibliographicProduct> getListOfBibliographicProducts() {
        return listOfBibliographicProducts;
    }

    public void setListOfBibliographicProducts(ArrayList<BibliographicProduct> listOfBibliographicProducts) {
        this.listOfBibliographicProducts = listOfBibliographicProducts;
    }

    

}


