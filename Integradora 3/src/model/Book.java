package model;



public class Book extends BibliographicProduct {

    private String review;
    private BookType bookType;
    public Book(String id, String name, int numberPages, String publishDate, double sellPrice, String url,String review,BookType bookType) {
        super(id, name, numberPages, publishDate, sellPrice, url);
   
        this.review = review;
        this.bookType = bookType;
    }

    public Book(Book bookToCopy) {
        super(bookToCopy.getId(), bookToCopy.getName(), bookToCopy.getNumberPages(), bookToCopy.getPublishDate(),bookToCopy.getSellPrice(),bookToCopy.getUrl());
   
        this.review = review;
        this.bookType = bookType;
        
    }


  
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }



   







}

