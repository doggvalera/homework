package sample;

import sample.model.AddressBook;
import sample.model.Entry;
import sample.model.EntryType;
import sample.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AddressBookSerializer {

    private static JAXBContext context;
    static {

        try {
            context = JAXBContext.newInstance(AddressBook.class,
                    Entry.class,
                    Person.class,
                    EntryType.class
            );
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void store(AddressBook ab) throws JAXBException{
        Marshaller m = context.createMarshaller();
        m.marshal(ab, getDataFile());
    }

    public static AddressBook load() throws JAXBException{
        Unmarshaller m = context.createUnmarshaller();
        return (AddressBook) m.unmarshal(getDataFile());

    }


    private static File getDataFile() {
        String userHome = System.getProperty("user.home");
        String fileSep = System.getProperty("file.separator");
        File addBookFilePath = new File((userHome + fileSep + "Address Book.xml"));
        return addBookFilePath;
    }
}
