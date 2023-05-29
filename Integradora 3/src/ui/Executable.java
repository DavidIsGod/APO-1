 package ui;

import java.util.Scanner;
import model.Controller;


public class Executable {
    
    private static Scanner reader;
    private static Controller controller;



    public Executable() {

        reader = new Scanner(System.in);
        controller = new Controller();

    }

    public static void main (String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    public void menu() {

       

        boolean cond = false;

        while (!cond){
            System.out.println("             WELCOME BACK TO READX                  ");
            System.out.println("Enter which function you want to use");
            System.out.println("1.Register a bibliographic Product");
            System.out.println("2.Delete a BiblioGraphic Product");
            System.out.println("3.Modify a Bibliographic Product");
            System.out.println("4.Register User");
            System.out.println("5.Buy a BiblioGraphic Product");
            System.out.println("6.Start a Reading Session");
            System.out.println("7.My library");
            System.out.println("8.Cancel a Subscription to a Magazine");
            System.out.println("9.Informs");
            System.out.println("0.Exit");
                int option = Integer.valueOf(reader.nextLine());

                switch (option){

                    case 1:
                    registerBiblioGraphicProduct();
                    break; 
                    case 2:
                    deleteProducts();
                    break;
                    case 3:
                    modifyProducts();
                    break;
                    case 4:
                    registerUser();
                    break;
                    case 5:
                    sellBook();
                    break;
                    case 6:
                    readingSession();
                    break;
                    case 7:
                    myLibrary();
                    break; 
                    case 8:
                    cancelSubs();
                    break;
                    case 9:
                    informs();
                    break;
                    case 0:
                    cond = true;
                    break;
                }
        }

    }

   
    public void myLibrary() {

        System.out.println("Please Select The User");
        System.out.println(controller.showUsersList());
        int idUser = Integer.valueOf(reader.nextLine());

        System.out.println(controller.myLibrary(idUser));

        if(controller.myLibrary(idUser) != null){
            
            System.out.println("Here is the Library of the User: ");
            System.out.println("");
        }else{
            
            System.out.println("No sirve");
        }



    }

    public void sellBook(){

        System.out.println("Please select the user that is going to buy");
        System.out.println(controller.showUsersList());
        int idUser = Integer.valueOf(reader.nextLine());
        int bibliographicProductIndex =  -1;

        System.out.println("Please select if you want to buy a book or a Magazine \n1.Book \n2.Magazine");
        String option = reader.nextLine();

        switch (option) {
            case "1":
                System.out.println(controller.showBookList());
                bibliographicProductIndex = Integer.valueOf(reader.nextLine());
                if(controller.sellBook(idUser, bibliographicProductIndex)){
                    System.out.println("-------------------------------------");
                    System.out.println("The book had been sold succesfully");
                    System.out.println("-------------------------------------");
        
                }else{
        
                    System.out.println("There was a problem buying the book, check System Memory");
        
                }
                break;
               

            case "2":
                System.out.println(controller.showMagazinesList());
                bibliographicProductIndex = Integer.valueOf(reader.nextLine());
                if(controller.sellMagazine(idUser, bibliographicProductIndex)){
                    System.out.println("-----------------------------------------");
                    System.out.println("The magazine had been sold succesfully");
                    System.out.println("----------------------------------------");
        
                }else{
        
                    System.out.println("There was a problem buying the book, check System Memory");
        
                }
                break;
        
            default:
                System.out.println("Invalid Option ");
                break;
        }

    
    }



    public void registerBiblioGraphicProduct(){

        System.out.println("Select what kind of product you want to Register ");
        System.out.println("1.Book \n2.Magazine"); 
        
        
        int biblioGraphicProductoption = Integer.valueOf(reader.nextLine());

        switch(biblioGraphicProductoption){

            case 1:
            
                regBook();
                break;
    
            case 2:
                regMagazine();
            break;
        }

    }

    

    public void deleteProducts(){

        System.out.println("what kind of product you want to delete \n1.Book \n2.Magazine");
        int typeDelete = Integer.valueOf(reader.nextLine());
        String query = controller.showBookList();
        String query2 = controller.showMagazinesList();

            switch(typeDelete){

                case 1:
                
                System.out.println("A continuacion los libros registrados en el sistema: ");
                
                System.out.println(query);

            System.out.println("Digite la opcion del objeto a borrar");
            int option = Integer.valueOf(reader.nextLine());

            if(controller.deleteBooks(option-1)){
                System.out.println("Book deleted succesfully");
            }else{
                System.out.println("Book couldnt be deleted");
            }
                break;

                case 2:
                System.out.println("A continuacion las revistas registradas en el sistema: ");

                System.out.println(query2);

                System.out.println("Digite la opcion del objeto a borrar");
                int option2 = Integer.valueOf(reader.nextLine());

                if(controller.deleteMagazines(option2-1)){
                    System.out.println("Objeto borrado con exito");
                }else{
                    System.out.println("Objeto no pudo ser borrado");
                }
                break;
            }
        }

           
    public static void regMagazine(){
        
        System.out.println("Type the id of the Magazine");
        String magazineId = reader.nextLine();

        
        System.out.println("Type the name of the Magazine");
        String magazineName = reader.nextLine();

        System.out.println("Write the number of pages in the Magazine");
        int magazineNumberPages = Integer.valueOf(reader.nextLine());

       System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
       String date = reader.nextLine();

        System.out.println("Select a Category for the Magazine \n1.Varieties \n2.Design \n3.Scientific");
        int magazineType = Integer.valueOf(reader.nextLine());

        
        System.out.println("Type the URL for the Magazine");
        String magazineURl = reader.nextLine();

        System.out.println("Write the value of the Magazine");
        int sellPriceMagazine = Integer.valueOf(reader.nextLine());

       
        System.out.println("Type the periodicity of the Magazine (Words)");
        String periodicity = reader.nextLine();

        if(controller.regMagazine(magazineId, magazineName, magazineNumberPages, date,magazineType, magazineURl, periodicity, sellPriceMagazine)){
           
            System.out.println("Magazine registered succesfully");
        }else{

            System.out.println("Error, there was a problem registering the book");
        }



    }
    
    public static void regBook() {
       
        System.out.println("Type the id of the Book");
        String id = reader.nextLine();

       
        System.out.println("Type the name of the Book");
        String name = reader.nextLine();

        System.out.println("Type the number of the pages in the Book");
        int numberPages = Integer.valueOf(reader.nextLine());

        
        System.out.println("Write a short review of the book");
        String review = reader.nextLine();

        System.out.println("Write the date of the publication as the next format: dd/MM/yyyy");
        String date = reader.nextLine();
        
        System.out.println("Select the gender of the Book \n1.Science Fiction \n2.Fantasy \n3.Historic Novel");
        int  genderBook = Integer.valueOf(reader.nextLine());

        System.out.println("Write the URL of the Book");
        String uRL = reader.nextLine();

        System.out.println("Type the sell Price of the Book");
        int sellPrice = Integer.valueOf(reader.nextLine());
        
        if (controller.regBook(id, name, numberPages, review, date, numberPages, uRL, sellPrice, genderBook, sellPrice)){
           
            System.out.println("------------------------");
            System.out.println("Book created succesfully");
            System.out.println("--------------------------");
        } else {
            System.out.println("Error creating the book");
        }
    }
    


    public void modifyProducts(){

        System.out.println("type if you want to modify a magazine or a Book \n1.Magazine \n2.Book");
        int option = Integer.valueOf(reader.nextLine());

        if(option == 1 ){
            String query = controller.showMagazinesList();
            System.out.println("Please select the magazine you want to change");
            System.out.println(query);

            int option2 = Integer.valueOf(reader.nextLine());

            System.out.println("Type the id of the Magazine");
            String newMagazineId = reader.nextLine();
    
            
            System.out.println("Type the name of the Magazine");
            String newMagazineName = reader.nextLine();
    
            System.out.println("Write the number of pages in the Magazine");
            int newMagazineNumberPages = Integer.valueOf(reader.nextLine());
    
           System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
           String newdate = reader.nextLine();
    
            System.out.println("Select a Category for the Magazine \n1.Varieties \n2.Design \n3.Scientific");
            String newMagazineType = reader.nextLine();
    
            
            System.out.println("Type the URL for the Magazine");
            String newMagazineURl = reader.nextLine();
    
            System.out.println("Write the value of the Magazine");
            int newSellPriceMagazine = Integer.valueOf(reader.nextLine());
    
           
            System.out.println("Type the periodicity of the Magazine (Words)");
            String newPeriodicity = reader.nextLine();

            System.out.println("This is the new information");
            System.out.println();

            if(controller.modifyMagazines(option,option2-1, newMagazineId, newMagazineName, newMagazineNumberPages, newdate, newMagazineNumberPages, newMagazineURl, newSellPriceMagazine, newPeriodicity)){
                System.out.println("---------------------------------");
                System.out.println("Magazine modified Succesfully");
                System.out.println("-------------------------------------");
            }else{
                System.out.println("Magazine couldnt be modified");
            }

            

        }else if(option == 2){
            
            String query = controller.showBookList();
            System.out.println("Please select the Book you want to change");
            System.out.println(query);

            int option2 = Integer.valueOf(reader.nextLine());

            System.out.println("Type the id of the Book");
            String newid = reader.nextLine();
    
           
            System.out.println("Type the name of the Book");
            String newName = reader.nextLine();
    
            System.out.println("Type the number of the pages in the Book");
            int newNumberPages = Integer.valueOf(reader.nextLine());
    
            
            System.out.println("Write a short review of the book");
            String newReview = reader.nextLine();
    
            System.out.println("Write the date of the publication as the next format: dd/MM/yyyy");
            String newDate = reader.nextLine();
            
            System.out.println("Select the gender of the Book \n1.Science Fiction \n2.Fantasy \n3.Historic Novel");
            int  newGenderBook = Integer.valueOf(reader.nextLine());
    
            System.out.println("Write the URL of the Book");
            String newURL = reader.nextLine();
    
            System.out.println("Type the sell Price of the Book");
            double newSellPrice = Integer.valueOf(reader.nextLine());

            if(controller.modifyBooks(option,option2-1,newid,newName,newNumberPages,newReview,newDate,newGenderBook,newURL,newSellPrice)){
                System.out.println("----------------------------");
                System.out.println("Book modified succesfully");
                System.out.println("------------------------------");
            }else{
                System.out.println("Book couldnt be modified");
            }

        }
        
     }
        

    public void registerUser(){

        System.out.println("Type ahead the information for a new User");

        //Limpieza de Buffer
        reader.nextLine();

        System.out.println("What kind of User is going to register? \n1.Premium \n2.Standard");
        int typeUser = Integer.valueOf(reader.nextLine());
        //Limpieza de Buffer
        reader.nextLine();

        System.out.println("Write the id");
        String id = reader.nextLine();

        System.out.println("Write the name");
        String name = reader.nextLine();


        if(controller.registerUser(id, name,typeUser)){

            System.out.println("------------------------------");
            System.out.println("User Successfully registered");
            System.out.println("----------------------------------");
        }else{

            System.out.println("There was an error registering the User");

        }
    }
    
    public void readingSession(){

        System.out.println("Which type of bibliographic Product you want to read \n1.Magazine \n2.Book");
        int optionToRead = Integer.valueOf(reader.nextLine());

        switch(optionToRead){

            case 1:
            
            int counterPages = 1;
            int optionUserRead = 0;
            int optionMagUser = 0;
            System.out.println("Select the User that wants to read");
            
            String query = controller.showMagazinesListOfUser(optionUserRead);
            String query2 = controller.showUsersList();
            System.out.println(query2);
             optionUserRead= Integer.valueOf(reader.nextLine());

             System.out.println("Here are the available products buyed by the User");
             System.out.println(query);
             optionMagUser = Integer.valueOf(reader.nextLine());

             

             
            System.out.println("Reading Session In Progress ");


             System.out.println("You are Actually Reading: " +query);

             System.out.println("Reading Page number" +counterPages);

             System.out.println("Type A for going to the Next Page");
             System.out.println("Type S for going to the last Page");
             System.out.println("Type B for going to the Library");
             String optionPagesUser = reader.nextLine();

            
             switch (optionPagesUser) {
                case "A":
                    counterPages++;
                    break;
                    case "S":
                    counterPages--;
                    break;
                    case "B":
                    myLibrary();
                    break;
                default:
                System.out.println("Please type a valid option");
                    break;
             }
             
            
            

            
           

            case 2:
            int counterPages2 = 0;
            int optionUserRead2 = 0;
            int optionBookUser = 0;
            System.out.println("Select the User that wants to read");
            
            String query3 = controller.showBookListOfUser(optionUserRead2);
            String query4 = controller.showUsersList();
            System.out.println(query4);
             optionUserRead2= Integer.valueOf(reader.nextLine());

             System.out.println("Here is the available products buyed by the User");
             System.out.println(query3);
             optionBookUser = Integer.valueOf(reader.nextLine()); 
            


            

            break;
        }
    }



    public void cancelSubs(){

        
        int idMag = 0;
        int userPosition = 0;
        String query = controller.showUsersList();
        String query2 = controller.showMagazinesListOfUser(userPosition);


        //mostrar users
         System.out.println("Select the User that Is Going to Cancel the Subscription");
         System.out.println(query);
          userPosition = Integer.valueOf(reader.nextLine());
        System.out.println(query2);
        int magazineToDelete = Integer.valueOf(reader.nextLine());
        
     
        if(controller.cancelSub(magazineToDelete, userPosition-1)){
            System.out.println("-------------------------------------");
            System.out.println("Subscription succesfully cancelled");
            System.out.println("---------------------------------------");
        }else{
            System.out.println("Cancellation of service couldnt be accepted");
        }

    
     
     

    }
   
    public void informs() {

        System.out.println("Select which inform youw want to see: ");
        System.out.println("1.Numer of Paged Read in Books/Magazines");
        System.out.println("2.Show the most read Book in the App");
        System.out.println("3.Show the top 5 of most  read Magazines or Books ");
        System.out.println("4.Show for each Genre the most sell books and the Total Gains");
        System.out.println("5.Show for each category the number of active subs and the Total Amount Paid ");
        
        int optionInform = Integer.valueOf(reader.nextLine());

        switch (optionInform) {
             case 1:
              
                break;

                case 2:

                break;

                case 3:

                break;

                case 4:

                break;

                case 5:

                break;
        

            default:
            System.out.println("Put a valid option");
                break;
        }
    }





}