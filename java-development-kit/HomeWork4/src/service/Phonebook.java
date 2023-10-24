package service;

import model.Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    public void addContact(ArrayList<Contact> list, Scanner scn) {
        System.out.println("Добавить новую запись?");
        System.out.println("q - Выход, Enter - продолжение");
        while (true) {
            String input = scn.nextLine();
            if (input.equals("q")) {
                break;
            } else {
                System.out.println("Введите табельный номер:");
                String id = scn.nextLine();
                System.out.println("Введите номер телефона:");
                String inputPhone = scn.nextLine();
                System.out.println("Введите Имя:");
                String inputFirstName = scn.nextLine();
                System.out.println("Введите стаж:");
                String inputExperience = scn.nextLine();
                System.out.println("q - Выход, Enter - продолжение");
                list.add(new Contact(id, inputPhone, inputFirstName, inputExperience));
            }
        }
    }

    public void deleteContact(ArrayList<Contact> list, Scanner scn) {
        System.out.println("Введите порядковый номер контакта для удаления");
        int in = scn.nextInt();
        scn.nextLine();
        list.remove(in - 1);
    }

    public void searchContactByExp(ArrayList<Contact> list, Scanner scn) {
        System.out.println("Введите стаж сотрудника");
        String input = scn.nextLine();
        for (Contact c : list) {
            if (c.getExperience().equals(input)) {
                c.print();
            }
        }
    }

    public void searchContactByName(ArrayList<Contact> list, Scanner scn) {
        System.out.println("Введите имя сотрудника");
        String input = scn.nextLine();
        for (Contact c : list) {
            if (c.getFirstName().equals(input)) {
                c.print();
            }
        }
    }

    public void searchContactById(ArrayList<Contact> list, Scanner scn) {
        System.out.println("Введите табельный номер сотрудника");
        String input = scn.nextLine();
        for (Contact c : list) {
            if (c.getId().equals(input)) {
                c.print();
            }
        }
    }
}
