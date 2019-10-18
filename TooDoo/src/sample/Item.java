package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Item {

    //initializes variable
    private String name;

    //create Item constructor
    public Item (String name){
        this.name = name;
    }

    //create toString method
    public String toString (){
        return name; //returns name of item
    }

    //getter for name var
    public String getName(){
        return name;
    }

    //writeToFile writes item name to unique file
    public void writeToFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r"); //separates variables with commas
        bw.write(";\r"); //semicolon denotes end of item
        bw.close();

    }

}
