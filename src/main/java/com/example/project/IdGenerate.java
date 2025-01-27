package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    public static String currentId = "99";
    // //requires one empty constructor

    public IdGenerate(){
        currentId = "99";
    }

    public static String getCurrentId(){ // returns the currentId public static variable
        return currentId;
    }

    public static void reset(){ // resets currentId back to 99
        currentId = "99";
    } //must reset the currentId back to 99


    public static void generateID(){ 
        int intId = Integer.parseInt(currentId); //converts string currentId to int
        intId++; // increments currentId
        currentId = String.valueOf(intId); // converts int Id back to currentId
        } //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
}