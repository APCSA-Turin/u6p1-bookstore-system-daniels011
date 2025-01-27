package com.example.project;

public class Book{
    private String title;
    private String author; 
    private int yearPublished; 
    private String isbn;
    private int quantity;

    // requires 1 constructor with 5 arguments that intitialize the attribtues of the class.

    public Book (String title, String author, int yearPublished, String isbn, int quantity){ 
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() { //returns title 
        return title;
    }

    public void setTitle(String title) { //title is set to title parameter 
        this.title = title;
    }
    public String getAuthor() { // returns author
        return author;
    }
    
    public void setAuthor(String author) { //sets the author to new parameter author
        this.author = author;
    }

    

    public int getYearPublished() { // returns year published
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) { //sets the year published to new parameter 
        this.yearPublished = yearPublished;
    }

    public String getIsbn() { //returns isbn
        return isbn;
    }

    public void setIsbn(String isbn) { // sets isbn to new isbn parameter
        this.isbn = isbn;
    }

    public int getQuantity() { // returns quantity 
        return quantity;
    }

    public void setQuantity(int quantity) { // sets quantity to new quantity parameter
        this.quantity = quantity;
    }

    public String bookInfo(){ //returns all the book info
        return ("Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn +  ", Quantity: " + quantity);
    } //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
       
}