package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import sample.model.AddressBook;
import sample.model.Entry;
import sample.model.EntryType;
import sample.model.Person;
import javafx.scene.control.ListView;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField addressBookNameField;
    @FXML
    private ListView<Person> personList;
    @FXML
    private TextField findNameField;
    @FXML
    private TextField entryTypeField;
    @FXML
    private TextField entryValueField;
    @FXML
    private Label findNameLabel;

    private AddressBook addressBook;




    @FXML
    public void onButtonUserAddClicked() {
        /**
         * Description add user
         *
         * @param 2 string from textFields
         * @return void
         */
        if (!firstNameTextField.getText().trim().isEmpty() && !lastNameTextField.getText().trim().isEmpty()) {
            Person p1 = new Person(firstNameTextField.getText(), lastNameTextField.getText());
            addressBook.getPersons().add(p1);
            showList();
        }
    }
    public void showList() {
        personList.getItems().setAll(addressBook.getPersons());
    }

    @FXML
    public void onButtonAddressBookCreated(){
        addressBook = new AddressBook(addressBookNameField.getText());
    }

    @FXML
    public void onButtonSaveFiles() throws JAXBException {

        AddressBookSerializer.store(addressBook);

    }

    @FXML
    public void onButtonLoadFile() throws JAXBException {
        addressBook  = AddressBookSerializer.load();
        showList();
    }


    @FXML
    public void onButtonFindUser() throws NullPointerException {
        List<Person> persons = addressBook.getPersons();

        for (Person p : persons) {
            if (p.getLastName().equalsIgnoreCase(findNameField.getText()) || p.getFirstName().equalsIgnoreCase(findNameField.getText())) {
                findNameLabel.setText(p.toString());
                System.out.println(p.toString());

            }
        }
    }

    @FXML
    public void onButtonAddEntry() throws NullPointerException{
        EntryType t = EntryType.valueOf(entryTypeField.getText());
        Person p = personList.getSelectionModel().getSelectedItem();
        p.setEntry(new Entry(t,entryValueField.getText()));
        showList();
    }



}
