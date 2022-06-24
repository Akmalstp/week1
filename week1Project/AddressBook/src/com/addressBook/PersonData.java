package com.addressBook;

import java.io.Serializable;
import javax.swing.*;

public class PersonData implements Serializable{

    private  String firstName;
    private String lastName;
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    private String address;

    public String getLastName() {
        return lastName;
    }

    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public PersonData(String f_Name, String l_Name, String mail, String address, String phone){
        this.firstName = f_Name;
        this.lastName = l_Name;
        this.email = mail;
        this.address = address;
        this.phone = phone;
    }
//    public void print(){
//        JOptionPane.showMessageDialog(null,"Name: " +firstName+" "+lastName+"\nEmail: "+email+"\nAddress: " +address+ "\nPhone No: "+ phone );
//        //System.out.println("Name: " +firstName+" "+lastName+"\nEmail: "+email+"\nAddress: " +address+ "\nPhone No: "+ phone);
//    }

    //use to print a person data.
    public void print(){
        System.out.println("Name: " +firstName+" "+lastName+"\nEmail: "+email+"\nAddress: " +address+ "\nPhone No: "+ phone);
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(" ");
    }


    public int compareTo(PersonData personData) {
        return lastName.compareTo(personData.getLastName());
    }
}
