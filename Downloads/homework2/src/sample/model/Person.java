package sample.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.NONE)
public class Person {
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;

    @XmlElement(name = "Entry")
    @XmlElementWrapper(name = "Entries")
    private List<Entry> entries = new ArrayList<Entry>();


    public Person() {
    }

    public Person(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public void setEntry(Entry entry){
        this.entries.add(entry);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", entries=" + entries +
                '}';
    }
}
