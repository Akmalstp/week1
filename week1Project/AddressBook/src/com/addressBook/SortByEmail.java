package com.addressBook;

import java.util.Comparator;

public class SortByEmail implements Comparator<PersonData> {
    @Override
    public int compare(PersonData p1, PersonData p2) {
        return p1.getEmail().toLowerCase().compareTo(p2.getEmail().toLowerCase());
    }
}
