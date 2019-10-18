package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateItem {

    //initializes variables
    private static String name;
    private static FileReader fr;
    private static BufferedReader br;

    private static ArrayList<Item> items = new ArrayList<>(); //creates ArrayList items that holds objects of Item class

    //createAllItems reads file containing list of items and appends them to items ArrayList
    public static ArrayList createAllItems(String fileName) throws IOException {

        fr = new FileReader(fileName);
        br = new BufferedReader(fr);

        String line;
        String itemString = "";

        //while loop loops through list file
        while((line = br.readLine()) != null){

            if(!line.equals(";")){ //before it reaches end of item
                itemString += line;
            } else {
                parseItem(itemString);
                itemString = "";
            }
        }
        return items;
    }

    //parseItem parses through each line in list file and to find item name
    private static void parseItem(String string){

        int pos = 0;
        String name = "";

        //for loop separates item name from each line and adds item to items ArrayList
        for(int i = 0; i < string.length(); i++){
            if(string.substring(i, i + 1).equals(",")){
                pos = i;
                name = string.substring(0, pos); //start of string to position before semicolon
            }
        }
        items.add(new Item(name));
    }
}
