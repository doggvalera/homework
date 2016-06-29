package sample.model;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Entry")
@XmlAccessorType(XmlAccessType.NONE)
public class Entry {
    @XmlAttribute(name = "Type")
    private EntryType type;
    @XmlValue
    private String value;

    public Entry() {
    }

    public Entry(EntryType type, String value) {
        this.type = type;
        this.value = value;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}

