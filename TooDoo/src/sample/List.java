package sample;

import java.util.Date;

//list class
public class List {

    //initialize variables
    private Date date;
    private String name;

    //create list constructor
    public List (String name, Date date){
        this.name = name;
        this.date = date;
    }

    //getter for name var
    public String getName(){
        return name;
    }

    //create toString method
    public String toString(){
        return "Name: " + name + " \t\t Date Created: " + date; //returns name of list and date list was created
    }
}
