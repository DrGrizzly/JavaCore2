package Homework3;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Contact implements Comparable {
    public String name;
    public String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static ArrayList<Contact> getArrayList(Stream<Contact> stream) {
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return phone;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Contact) o).name);
    }
}
