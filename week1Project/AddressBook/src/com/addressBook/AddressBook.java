package com.addressBook;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class AddressBook {
    ArrayList<PersonData> persons;

    public AddressBook() {
       persons = new ArrayList<>();
        FileInputStream f;
        ObjectInputStream o = null;
       try {
           f = new FileInputStream("Phone.txt");
           o = new ObjectInputStream(f);
           PersonData p;
           do{
               p = (PersonData) o.readObject();
               if(p != null){
                   persons.add(p);
               }
           }while(p != null);

       }catch (Exception ex){
           System.out.println("Calculator is loaded!");
       }
       finally {
           if(o != null) {
               try {
                   o.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
       }
    }
    //add method
    public void addNew(ArrayList<PersonData> persons){

            String f_Name = JOptionPane.showInputDialog("Enter first name");
            String l_Name = JOptionPane.showInputDialog("Enter last name");
            String address = JOptionPane.showInputDialog("Enter address");
            String email = JOptionPane.showInputDialog("Enter email address");
            String pNum = JOptionPane.showInputDialog("Enter phone no");

            PersonData p = new PersonData(f_Name, l_Name, email, address, pNum);
            persons.add(p);
            JOptionPane.showMessageDialog(null, p.getFirstName() + " is added successfully!");


    }

    //search method
    public void searchPerson(String name){
        for(int d = 0; d < persons.size(); d++){
            PersonData p = persons.get(d);
            if(name.equals(p.getFirstName())){
                p.print();

            }
        }
    }
    //Delete method
    public void deletePerson(String name){
        for(int i = 0; i < persons.size(); i++){
            PersonData p = persons.get(i);
            if(name.equals(p.getFirstName())){
                persons.remove(p);
                JOptionPane.showMessageDialog(null,p.getFirstName()+" is deleted successfully!");
            }
        }
    }
    //show some records
    public void show(ArrayList<PersonData> pList){
        for (PersonData p: pList) {
            p.print();
        }
    }
    //save the phone book in local disk
    public void savePB(ArrayList<PersonData> personList){
        try {
            FileOutputStream fo = new FileOutputStream("Phone.txt");
            ObjectOutputStream ob = new ObjectOutputStream(fo);
            for (int i = 0; i < persons.size(); i++) {
                ob.writeObject(persons.get(i));
            }
            ob.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    // sorting the Addressbook
    public void customSort(){
        String input = JOptionPane.showInputDialog("Choose field to sort: " + "\n1:- First Name"+ "\n2:- Last Name"+ "\n3:- Phone Number"+ "\n4:-Address"+ "\n5:- Email Address");
        int cs = Integer.parseInt(input);
        switch (cs) {
            case 1:
                SortByFName f = new SortByFName();
                Collections.sort(persons, f);
                break;
            case 2:
                SortByLName l = new SortByLName();
                Collections.sort(persons, l);
                break;
            case 3:
                SortByPhone p = new SortByPhone();
                Collections.sort(persons, p);
                break;
            case 4:
                SortByAddress a = new SortByAddress();
                Collections.sort(persons, a);
            case 5:
                SortByEmail e = new SortByEmail();
                Collections.sort(persons, e);
        }
        show(persons);
    }
    public void defaultSort(){
        SortByFName f = new SortByFName();
        Collections.sort(persons, f);
        show(persons);
    }
    //method to search last name ends with
    public void lNameEndsWith(String cl){
        for(PersonData p : persons){
            if(p.getLastName().endsWith(cl)){
                p.print();
            }
        }
    }
    //method to search first name ends with
    public void fNameEndsWith(String cl){
        for(PersonData p : persons){
            if(p.getFirstName().endsWith(cl)){
                p.print();
            }
        }
    }
    //method to search last name start with
    public void lNameStartsWith(String cl){
        for(PersonData p : persons){
            if(p.getLastName().startsWith(cl)){
                p.print();
            }
        }
    }
    //method to search first name starts with
    public void fNameStartsWith(String cl){
        for(PersonData p : persons){
            if(p.getFirstName().startsWith(cl)){
                p.print();
            }
        }
    }
    //method to check email ends with
    public void emailEndsWith(String cl){
        for(PersonData p : persons){
            if(p.getEmail().endsWith(cl)){
                p.print();
            }
        }
    }
    // method to check email starts with
    public void emailStartsWith(String cl){
        for(PersonData p : persons){
            if(p.getEmail().startsWith(cl)){
                p.print();
            }
        }
    }

    //method to call like method
    public void likeSearch() {
        String input = JOptionPane.showInputDialog("1:- First Name ends with" + "\n2:- First Name starts with" + "\n3:- Last Name ends with" + "\n4:- First Name starts with" + "\n5:- Email starts with" + "\n6:- Email ends with");
        int cs = Integer.parseInt(input);

        switch (cs) {
            case 1:
                String sKey = JOptionPane.showInputDialog("Enter ending of first name");
                fNameEndsWith(sKey);
                break;
            case 2:
                sKey = JOptionPane.showInputDialog("Enter starting of first name");
                fNameStartsWith(sKey);
                break;
            case 3:
                sKey = JOptionPane.showInputDialog("Enter ending of last name");
                lNameEndsWith(sKey);
                break;
            case 4:
                sKey = JOptionPane.showInputDialog("Enter starting of last name");
                lNameStartsWith(sKey);
                break;
            case 5:
                sKey = JOptionPane.showInputDialog("Enter starting of email");
                emailStartsWith(sKey);
                break;
            case 6:
                sKey = JOptionPane.showInputDialog("Enter ending of email");
                emailEndsWith(sKey);
                break;
        }
    }
}
