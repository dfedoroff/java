package io;

import model.Contact;
import interfaces.Readable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader implements Readable {
    @Override
    public void readFromFile(ArrayList<Contact> contactsList) {
        File file = new File("phonebook.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String phoneNumber = parts[1];
                String firstName = parts[2];
                String experience = parts[3];
                contactsList.add(new Contact(id, phoneNumber, firstName, experience));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
