package com.addressBook;
import java.util.Comparator;

public class SortByFName implements Comparator<PersonData>{

    @Override
    public int compare(PersonData p1, PersonData p2) {
        return p1.getFirstName().toLowerCase().compareTo(p2.getFirstName().toLowerCase());
    }
}
