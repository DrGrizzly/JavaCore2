package Homework3;

import java.util.ArrayList;

public class PhoneDict {
    private ArrayList<Contact> phoneList;

    public ArrayList<Contact> get(String name) {
        if (phoneList == null)
            return new ArrayList();
        return Contact.getArrayList(phoneList.stream().filter(phone -> phone.name == name));
    }

    public void add(String name, String phone) {
        if (phoneList == null)
            phoneList = new ArrayList();
        phoneList.add(new Contact(name, phone));
    }


}
