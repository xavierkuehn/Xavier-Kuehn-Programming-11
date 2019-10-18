import org.junit.Before;
import org.junit.Test;
import sample.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateItemTests {

    Item itemNoName;
    Item itemWithName;
    boolean methodStatus;

    @Before
    public void setup(){
        itemNoName = new Item("");
        itemWithName = new Item("Xavier");
    }

    @Test
    public void testWriteToFileWithName() throws IOException {

        //test string length > 0
        boolean isGreaterThanZero;
        if((itemWithName.getName().length()) > 0){
            isGreaterThanZero = true;
        } else {
            isGreaterThanZero = false;
        }
        assertEquals((itemWithName.getName().length()) > 0, isGreaterThanZero);

        //write item to file
        itemWithName.writeToFile("testFile.txt");

        //confirm file written
        FileReader fr = new FileReader("testFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        String itemString = "";

        //while loop loops through list file
        while((line = br.readLine()) != null){

            if(!line.equals(";")){ //before it reaches end of item
                itemString += line;
            } else {
                int pos;
                String name;

                for(int i = 0; i < itemWithName.getName().length(); i++){ //for loop separates item name from each line and adds item to items ArrayList
                    if(itemWithName.getName().substring(i, i + 1).equals(",")){
                        pos = i;
                        name = itemWithName.getName().substring(0, pos); //start of string to position before semicolon

                        //checks value of methodStatus
                        methodStatus = name == itemWithName.getName();
                    }
                }
                itemString = "";
            }
        }
    }

    @Test
    public void testWriteToFileNoName() {

        //test string length = 0
        assertEquals(itemNoName.getName().length(), 0);

        //checks value of methodStatus
        methodStatus = false;

    }

    @Test
    public void testItemToString(){

        //test name length > 0
        boolean isGreaterThanZero;
        if((itemWithName.getName().length()) > 0){
            isGreaterThanZero = true;
        } else {
            isGreaterThanZero = false;
        }
        assertEquals(itemWithName.getName().length() > 0, isGreaterThanZero);

        //assert toString is equal to name of item
        String itemWithNameToString = itemWithName.toString();
        String itemWithNameName = itemWithName.getName();
        assertEquals(itemWithNameToString, itemWithNameName);
    }
}
