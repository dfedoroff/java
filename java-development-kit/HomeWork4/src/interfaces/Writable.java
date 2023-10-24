package interfaces;

import model.Contact;
import java.io.IOException;
import java.util.ArrayList;

public interface Writable {
    void writeToFile(ArrayList<Contact> contactsList) throws IOException;
}
