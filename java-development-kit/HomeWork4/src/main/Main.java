package main;

import model.Contact;
import service.Phonebook;
import io.Reader;
import io.Writer;
import ui.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String QUIT = "q";
    private static final String SHOW_CONTACTS = "1";
    private static final String ADD_CONTACT = "2";
    private static final String SEARCH_BY_EXP = "3";
    private static final String SEARCH_BY_NAME = "4";
    private static final String SEARCH_BY_ID = "5";
    private static final String DELETE_CONTACT = "6";
    private static final String SAVE_TO_FILE = "7";

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {
            Phonebook phonebook = new Phonebook();
            ArrayList<Contact> contactsList = new ArrayList<>();
            Reader reader = new Reader();
            reader.readFromFile(contactsList);
            Menu menu = new Menu();

            while (true) {
                menu.mainMenu();
                String input = scn.nextLine();
                if (QUIT.equals(input)) {
                    break;
                } else if (SHOW_CONTACTS.equals(input)) {
                    for (int i = 0; i < contactsList.size(); i++) {
                        System.out.print(i + 1 + ". ");
                        contactsList.get(i).print();
                    }
                    menu.pressEnter(scn);
                } else if (ADD_CONTACT.equals(input)) {
                    phonebook.addContact(contactsList, scn);
                } else if (SEARCH_BY_EXP.equals(input)) {
                    phonebook.searchContactByExp(contactsList, scn);
                    menu.pressEnter(scn);
                } else if (SEARCH_BY_NAME.equals(input)) {
                    phonebook.searchContactByName(contactsList, scn);
                    menu.pressEnter(scn);
                } else if (SEARCH_BY_ID.equals(input)) {
                    phonebook.searchContactById(contactsList, scn);
                    menu.pressEnter(scn);
                } else if (DELETE_CONTACT.equals(input)) {
                    phonebook.deleteContact(contactsList, scn);
                    menu.pressEnter(scn);
                } else if (SAVE_TO_FILE.equals(input)) {
                    Writer writer = new Writer();
                    writer.writeToFile(contactsList);
                }
            }
        }
    }
}
