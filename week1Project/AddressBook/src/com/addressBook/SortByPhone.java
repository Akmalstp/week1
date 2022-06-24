package com.addressBook;

import java.util.Comparator;

public class SortByPhone implements Comparator<PersonData> {

    @Override
    public int compare(PersonData p1, PersonData p2) {
        return p1.getPhone().toLowerCase().compareTo(p2.getPhone().toLowerCase());
    }
}
