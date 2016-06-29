package sample.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "AddressBook")
@XmlAccessorType(XmlAccessType.NONE)
public class AddressBook {
    @XmlAttribute
    private String name;
    @XmlElementWrapper(name = "Persons")
    @XmlElement(name = "Person")
    private List<Person> persons = new ArrayList<>();

    @Override
    public String toString() {
        return "AddressBook{" +
                "name='" + name + '\'' +
                ", persons=" + persons +
                '}';
    }

    public AddressBook() {
    }

    public AddressBook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}