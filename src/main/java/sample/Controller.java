package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

    public void addContact(){
        String nameStr = name.getText();
        String phoneStr = phone.getText();
        String emailStr = email.getText();
        if(!nameStr.equals("") && !phoneStr.equals("") && !emailStr.equals("")) {
            Contact contact = new Contact(nameStr, phoneStr, emailStr);
            contacts.add(contact);
            name.setText("");
            phone.setText("");
            email.setText("");
        }
    }

    public void removeContact(){
        Contact contact = (Contact)list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

//    public void saveContacts(List<Contact> contacts){
//        JsonSerializer serializer = new JsonSerializer();
//        String json = serializer.serialize(contacts);
//
//        File f = new File("cars.json");
//        FileWriter fw = new FileWriter(f);
//        fw.write(json);
//        fw.close();
//    }
}
