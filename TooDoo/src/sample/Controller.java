package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
    //initializes all variables and observable lists
    public ListView<Item> itemsListView;
    public TextField fieldItemName;
    public Button buttonAddItem;
    public Button buttonRemoveItem;
    public TextField fieldListName;
    public Button buttonSaveList;
    public Button buttonLoadList;
    public ListView<List> listListView;
    public Button buttonDeleteList;
    public Button buttonClear;

    private int listNum = 1;

    private ObservableList<Item> items = FXCollections.observableArrayList();
    private ObservableList<List> lists = FXCollections.observableArrayList();

    //saveList saves list, named in fieldListName, to listListView which displays the name of the list and the date it was created
    public void saveList(ActionEvent actionEvent) throws IOException {
        ObservableList<Item> todoList = itemsListView.getItems(); //contains items from itemsListView
        Date date = new Date();

        //checks if listListView contains list with same name as fieldListName
        if(listListView.getItems().size() > 0){
            for (int i = 0; i < lists.size(); i++){ //loops through observable list, lists
                if(lists.get(i).getName().equals(fieldListName.getText())){ //if name of list in lists equals fieldListName, add listNum suffix
                    lists.add(new List((fieldListName.getText() + listNum), date)); //adds new list, named from fieldListName plus listNum suffix, with specific date, to lists
                    listListView.setItems(lists); //listListView is set to all items in lists

                    //loops through todoList, containing items, and calls the inherent writeToFile method of class Item, for each item in todoList
                    for (Item f : todoList) {
                        f.writeToFile((fieldListName.getText() + listNum));
                    }
                    listNum++;
                    break;
                } else {
                    lists.add(new List(fieldListName.getText(), date)); //adds new list, named from fieldListName, with specific date, to lists
                    listListView.setItems(lists); //listListView is set to all items in lists

                    //loops through todoList, containing items, and calls the inherent writeToFile method of class Item, for each item in todoList
                    for (Item f : todoList) {
                        f.writeToFile(fieldListName.getText());
                    }
                }
            }
        } else {
            lists.add(new List(fieldListName.getText(), date)); //adds new list, named from fieldListName, with specific date, to lists
            listListView.setItems(lists); //listListView is set to all items in lists

            //loops through todoList, containing items, and calls the inherent writeToFile method of class Item, for each item in todoList
            for (Item f : todoList) {
                f.writeToFile(fieldListName.getText());
            }
        }

        //resets fields and disables buttons
        itemsListView.getItems().clear();
        buttonSaveList.setDisable(true);
        buttonLoadList.setDisable(false);
        fieldListName.clear();
    }

    //loadList loads list with name from fieldListName
    public void loadList(ActionEvent actionEvent) throws IOException {
        itemsListView.getItems().clear();
        ArrayList<Item> items = CreateItem.createAllItems(fieldListName.getText()); //creates ArrayList items and sets it to method createAllItems of CreateItem class
        for (Item i: items) { //loops through observable list, items, and for each items it adds the item to the itemsListView
            itemsListView.getItems().add(i);
        }

        buttonSaveList.setDisable(true);
        fieldListName.clear();
    }

    //removes item from itemsListView
    public void removeItem(ActionEvent actionEvent) {
        Item item = itemsListView.getSelectionModel().getSelectedItem(); //temp Item, item, is set to selected item in itemsTableView
        items.remove(item); //removes temp item from observable list, items

        itemsListView.setItems(items); //sets itemsListView to updated items
    }

    //adds item to itemsListView
    public void addItem(ActionEvent actionEvent) {
        Item item = new Item(fieldItemName.getText()); //temp Item, item, is instantiated and the name is set to fieldItemName
        items.add(item); //adds item to observable list, items

        //resets fields and buttons
        itemsListView.setItems(items); //set itemsListView to items in observable list, items
        fieldItemName.clear();
        buttonAddItem.setDisable(true);
        buttonRemoveItem.setDisable(false);
    }

    //enables save button
    public void enableSave(KeyEvent keyEvent) {
        buttonSaveList.setDisable(false);
    }

    //enables add button
    public void enableAdd(KeyEvent keyEvent) {
        buttonAddItem.setDisable(false);
    }

    //deletes list from listListView, similar to remove item
    public void deleteList(ActionEvent actionEvent) {
        List list = listListView.getSelectionModel().getSelectedItem(); //creates temp list which is set to selected list from listListView
        lists.remove(list); //removes list from observable list, lists

        listListView.setItems(lists); //listListView is set to lists in observable list, lists
    }

    public void disableSave(MouseEvent mouseEvent) {
//        buttonSaveList.setDisable(true);
//        fieldListName.clear();
    }

    public void clearList(ActionEvent actionEvent) {
        itemsListView.getItems().removeAll();
        items.setAll(itemsListView.getItems());

        itemsListView.setItems(items);
    }
}
