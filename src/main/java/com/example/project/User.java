package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String id;
    private Book[] books = new Book[5]; 
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String getName() { // returns name
        return name;
    }

    public void setName(String name) { // sets name to new name parameter
        this.name = name;
    }

    public String getId() { // returns id
        return id;
    }

    public void setId(String id) { // sets id to new id parameter
        this.id = id;
    }

    public Book[] getBooks() { // returns book list
        return books;
    }

    public void setBooks(Book[] books) { // sets book list to a new book list parameter
        this.books = books;
    }

    public String bookListInfo(){ // returns info about the booklist
        String bookInfo = "";
        Book firstBook = books[0];
        if (firstBook.getTitle() == null) {
            return "empty";
        } else {
            bookInfo += "Name: " + getName();
            bookInfo += ("\n Id: " + getId());
            bookInfo += ("\n Books: ");
            for (Book bookIndex : books){
                bookInfo += ("\n" + bookIndex.bookInfo());
            }
            return bookInfo;
        }
    } //returns a booklist for the user, if empty, output "empty"

    public String userInfo(){ // returns all the user info
        String userInfo = "";
        userInfo += "Name: " + getName();
        userInfo += ("\nId: " + getId());
        userInfo += ("\nBooks: \n");
        for (Book bookIndex : books){
            if (bookIndex == null){
                userInfo += "empty\n";
            } else {
              userInfo += (bookIndex.bookInfo() + "\n");  
            }
            
        }
            return userInfo;
        }
    } //returns  "Name: []\nID: []\nBooks:\n[]"
       
