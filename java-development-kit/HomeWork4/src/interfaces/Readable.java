package interfaces;

import model.Contact;
import java.util.ArrayList;

public interface Readable {
    void readFromFile(ArrayList<Contact> contactsList);
}
