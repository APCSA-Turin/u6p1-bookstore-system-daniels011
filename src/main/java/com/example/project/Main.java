package com.example.project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exitProgram = false;
        Scanner scanner = new Scanner(System.in);
        BookStore store = new BookStore(); // makes a new bookstore object 

        while (exitProgram == false){
            displayMenu(); // after every iteration of the loop the main menu is displayed up with all the options
            int option = scanner.nextInt();
            scanner.nextLine(); 

            if (option == 0) {
                exitProgram = true;
            } 
            else if (option == 1) {  // add a book to the store asks all the neccesary information to create 
                System.out.print("Enter the isbn of your book: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter the name of your book: ");
                String title = scanner.nextLine();
                System.out.print("Enter the Author Name: ");
                String author = scanner.nextLine();
                System.out.print("Enter the year your book was published: ");
                int yearPublished = scanner.nextInt();
                System.out.print("Enter the Quantity of Books: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); 

                Book b1 = new Book(title, author, yearPublished, isbn, quantity); //creates a new book object for the book
                store.addBook(b1); // adds the new book to the store
                System.out.println("Your book was added successfully!");
            } 
            else if (option == 2) {
                System.out.print("Enter the isbn of your book to upgrade it: ");
                String upgradeIsbn = scanner.nextLine();

                boolean bookUpgradeFound = false;
                
                for (Book book : store.getBooks()) {
                    if (book != null && book.getIsbn().equals(upgradeIsbn)) {
                        book.setQuantity(book.getQuantity() + 1); //increments the quantity of the book by 1
                        System.out.println("Book quantity was upgraded/incremented by 1 successfully!!");
                        bookUpgradeFound = true;
                    }
                }
                
                if (!bookUpgradeFound) {
                    System.out.println("Book does not exist");
                }
            } 
            else if (option == 3) { // returns a specific book the user desires
                System.out.print("Enter the isbn of your book: ");
                String searchIsbn = scanner.nextLine();
                boolean found = false;
                
                for (Book book : store.getBooks()) { // iterates through the books in the store and locates the book through the serial number or isbn
                    if (book != null && book.getIsbn().equals(searchIsbn)) {
                        System.out.println("\nBook Found:");
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Quantity: " + book.getQuantity());
                        found = true;
                    }
                }
                
                if (!found) {
                    System.out.println("Book not found.");
                
                }
            } 
            else if (option == 4) { //displays all the books entrys in the store
                
                if (store.getBooks() == null || store.getBooks().length == 0) { // checks if the store is empty or not 
                    System.out.println("the store is empty :( ");
                
                } else {
                    System.out.println("\nHere are all the books in the store:");
                    
                    for (Book book : store.getBooks()) {  
                        if (book != null) {
                            System.out.println("\nISBN: " + book.getIsbn());
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("Quantity: " + book.getQuantity());
                        }
                    }
                }
            } 
            else if (option == 5) { // registers user with needed parameters
                System.out.print("Enter the Student's ID: ");
                String studentId = scanner.nextLine();
                System.out.print("Enter the Student's Name: ");
                String studentName = scanner.nextLine();

                User student1 = new User(studentName, studentId);
                store.addUser(student1);
                
                System.out.println("Student was registered successfully!");
            } 
            else if (option == 6) { //prints out all the registered users in the store
                if (store.getUsers() == null || store.getUsers().length == 0) { //
                    System.out.println("No students are registered in this store :(.");
                } else {
                    System.out.println("\nRegistered Students:");
                    for (User user : store.getUsers()) {
                        if (user != null) {
                            System.out.println("\nStudent ID: " + user.getId());
                            System.out.println("Name: " + user.getName());
                            System.out.println("Books Borrowed: " + user.bookListInfo());
                        }
                    }
                }
            }
            else if (option == 7) {
                System.out.print("Enter the Student's ID: ");
                String checkoutStudentId = scanner.nextLine();

                System.out.print("Enter the Book's ISBN: ");
                String checkoutIsbn = scanner.nextLine();

                // first checks if the student exists first in the store 
                User checkoutStudent = null;
                for (User user : store.getUsers()) {
                    if (user != null && user.getId().equals(checkoutStudentId)) { //compares the given user id with ids in the store then assigns the found user to a new checkoutstudent object
                        checkoutStudent = user;
                    }
                }

                if (checkoutStudent == null) { // if the student doesn't exist then the check out stops
                    System.out.println("Student not found.");
                } else {
                    // checks if the student has space in his book inventory 
                    boolean hasSlots = false;
                    for (Book spaceSlot : checkoutStudent.getBooks()) {
                        if (spaceSlot == null) {
                            hasSlots = true;
                        }
                    }

                    if (!hasSlots) {
                        System.out.println("Student's inventory has no space for new books(max is 5).");
                    } else {
                        // finds the desired book the user wants to checkout
                        Book checkoutBook = null;
                        for (Book book : store.getBooks()) {
                            if (book != null && book.getIsbn().equals(checkoutIsbn)) {
                                checkoutBook = book;
                            }
                        }

                        if (checkoutBook == null) { //checks if the book exists 
                            System.out.println("Book not found.");
                        } else if (checkoutBook.getQuantity() <= 0) { // checks if the book does exist but is all taken (even if quantity is 0 it can still exist in the store)
                            System.out.println("Book out of stock.");
                        } else {
                            checkoutBook.setQuantity(checkoutBook.getQuantity() - 1); // decreases quantity of the book in the store 
                            for (int i = 0; i < checkoutStudent.getBooks().length; i++) { // iterates through the students books to find a blank place in the inventory to put the book
                                if (checkoutStudent.getBooks()[i] == null) {
                                    checkoutStudent.getBooks()[i] = checkoutBook;
                                    System.out.println("Book checked out successfully!");
                                    break; // makes sure the book isn't added in all the empty places just one
                                }
                            }
                        }
                    }
                }
            } 
            else if (option == 8) {
                System.out.print("Enter the Student's ID: ");
                String returnStudentId = scanner.nextLine();

                System.out.print("Enter the Book's ISBN: ");
                String returnIsbn = scanner.nextLine();

                // first checks if the student exists first in the store 
                User returnStudent = null;
                for (User user : store.getUsers()) {
                    if (user != null && user.getId().equals(returnStudentId)) { //compares the given user id with ids in the store then assigns the found user to a new checkoutstudent object
                        returnStudent = user;
                    }
                }

                if (returnStudent == null) {
                    System.out.println("Student not found.");
                } else {
                    boolean bookReturned = false;
                    
                    for (int i = 0; i < returnStudent.getBooks().length; i++) { // iterates through the students's inventory to find the desired (undesired) book
                        Book returnBook = returnStudent.getBooks()[i]; 
                        
                        if (returnBook != null && returnBook.getIsbn().equals(returnIsbn)) { //checks if the book slot has a book there and checks if the isbns line up
                            returnStudent.getBooks()[i] = null; // the student loses the book from his inventory
                           
                            for (Book storeBook : store.getBooks()) { 
                                if (storeBook != null && storeBook.getIsbn().equals(returnIsbn)) { // finds the book in the store
                                    storeBook.setQuantity(storeBook.getQuantity() + 1); //increases the quantity of that book store by 1
                                    break;
                                }
                            }
                            bookReturned = true;
                            
                            System.out.println("Book was returned successfully!");
                        }
                    }
                    if (!bookReturned) {
                        System.out.println("Book not checked out by this student.");
                    }
                }
            } else {
                System.out.println("you picked an incorrect option look at the options in the menu!");
            }
    }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("******************Welcome to the GFG Library!******************");
        System.out.println("              Select From The Following Options:               ");
        System.out.println("**********************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book.");
        System.out.println("Press 8 to Check In Book.");
        System.out.println("------------------------------------------------------------");
    }
}