package com.addressBook;

import java.util.Comparator;

public class SortByAddress implements Comparator<PersonData> {
    @Override
    public int compare(PersonData p1, PersonData p2) {
        return p1.getAddress().toLowerCase().compareTo(p2.getAddress().toLowerCase());
    }
}
