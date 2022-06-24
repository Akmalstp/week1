package com.addressBook;

import javax.swing.*;
import java.util.Collections;


public class AddressBookDriver {
    public static void main(String[] args) {
        AddressBook aB = new AddressBook();
        String input, s;
        int cs;

        try {
            while (true) {
                input = JOptionPane.showInputDialog("Enter 1 to add" + "\nEnter 2 to search" + "\nEnter 3 to delete" + "\nEnter 4 to save" + "\nEnter 5 to show records" + "\nEnter 6 for like search AddressBook" + "\nEnter 7 for custom sort AddressBook" + "\nEnter 8 for default sort" + "\nEnter 9 to exit.");
                cs = Integer.parseInt(input);

                switch (cs) {
                    case 1:
                        aB.addNew(aB.persons);
                        break;
                    case 2:
                        s = JOptionPane.showInputDialog("Enter name to search");
                        aB.searchPerson(s);
                        break;
                    case 3:
                        s = JOptionPane.showInputDialog("Enter name to delete");
                        aB.deletePerson(s);
                        break;
                    case 4:
                        aB.savePB(aB.persons);
                        break;
                    case 5:
                        aB.show(aB.persons);
                        break;
                    case 6:
                        aB.likeSearch();
                        break;
                    case 7:
                        aB.customSort();
                        break;
                    case 8:
                        SortByLName l = new SortByLName();
                        Collections.sort(aB.persons, l);
                        aB.show(aB.persons);
                        break;
                    case 9:
                        aB.savePB(aB.persons);
                        System.exit(0);
                }
            }
        }
        catch (Exception e){
            System.out.println("Thank you for using my Address Book!");
        }
        }
    }

