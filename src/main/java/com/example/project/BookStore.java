package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users = new User[10];
    //requires 1 empty constructor

    public BookStore(){
    }

    public User[] getUsers(){ //returns users 
        return users;
    }

    public void setUsers(User[] users){ //takes in users array and replaces the instance array
        this.users = users;
    }

    public Book[] getBooks(){ // returns book array 
        return books;
    }

    public void addUser(User user){ //adds user object at an empty slot in the array
        boolean emptySlot = false; // variable to exit the loop once an empty slot is found
        for (int i = 0; i < users.length & emptySlot == false; i++){ //iterates through the users array and before an empty slot is found
            if ((users[i] == null)){  //condition to check for empty slot
                users[i] = user;
                emptySlot = true;
            }
        }
    } 

    public void removeUser(User user){ //removes user at index 
        User[] newUsers = new User[users.length]; // creates new array
        int index = 0;
        for (int i = 0; i < users.length; i++){
            if (!(users[i] == user)){ //if user is not in that index then it is added to the new array
                newUsers[index] = users[i];
                index++; // this variable makes sure that if the index of the undesired user is found it wont increment creating a null object in the array
            } 
        
        }
        users = newUsers; // assigns old array to new array memory location
    }

    public void consolidateUsers(){ // takes all user objects and shifts them to the front
        User[] newUsers = new User[users.length]; 
        int index = 0;
        for (int i = 0; i < users.length; i++){
            if (!(users[i] == null)){ // if an object isn't empty then it goes to the front of the new user array
                newUsers[index] = users[i];
                index++;
            }
        }
        users = newUsers; 
    }

    public void addBook(Book book){ 
        int length = 0;
        if (books != null){ // checks books array for emptyness
            length = books.length;
        }
        Book[] newBooks = new Book[length + 1]; // create new array with one more index
        for (int i = 0; i < length; i++){ 
            newBooks[i] = books[i]; 
        }
        newBooks[newBooks.length - 1] = book; //adds new book at the end
        books = newBooks;
    }

    public void insertBook(Book book, int index){
        Book[] newBooks = new Book[books.length + 1]; 
        for (int i = 0; i < index; i++){ // all books before the index are added to the new array
            newBooks[i] = books[i];
        }
        newBooks[index] = book; // new book is added in specified  index 
        for (int i = index; i < books.length; i++){ // the rest of the original array is added to the new array
            newBooks[i+1] = books[i];
        }
        books = newBooks;
    } 
    public void removeBook(Book book){
        if (book.getQuantity() > 1){ //check if the quantity is greater than 1 so we know if to either delete from quantity or delete it entirely
            for (int i = 0; i < books.length; i++){ // iterating through 
                if (books[i] == book){
                    books[i].setQuantity(book.getQuantity() - 1);
                }
            }
        } else {
            Book[] newBooks = new Book[books.length - 1]; // make new book array with length one less
            int index = 0;
            for (int i = 0; i < books.length; i++){ // iterate through original book array locating the book
                if (!(books[i] == book)){ 
                    newBooks[index] = books[i];
                    index++;
                } 
        }
        books = newBooks;
    }
        
    }
       
    public String bookStoreBookInfo(){ // prints all the book info for each book
        String bookInfo = "";
        for (Book book : books) {
            if (book != null) {
                bookInfo += book.bookInfo();
            }
        }
        return bookInfo;
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){ //prints user info for each user
        String userInfo = "";
        for (User user : users) {
            if (user != null) {
                userInfo += user.userInfo();
            }
        }
        return userInfo;
    
    } //you are not tested on this method but use it for debugging purposes

}