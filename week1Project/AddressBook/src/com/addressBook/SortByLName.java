package com.addressBook;

import java.util.Comparator;

public class SortByLName implements Comparator<PersonData> {

    @Override
    public int compare(PersonData p1, PersonData p2) {
        return p1.getLastName().toLowerCase().compareTo(p2.getLastName().toLowerCase());

    }
}
