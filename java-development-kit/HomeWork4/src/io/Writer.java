package io;

import model.Contact;
import interfaces.Writable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer implements Writable {
    @Override
    public void writeToFile(ArrayList<Contact> contactsList) throws IOException {
        try (FileWriter writer = new FileWriter("phonebook.csv", false)) {
            for (Contact c : contactsList) {
                writer.write(
                        c.getId() + "," + c.getPhoneNumber() + "," + c.getFirstName() + "," + c.getExperience() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
