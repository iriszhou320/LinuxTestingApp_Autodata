package net.autodata.linuxtest;

import java.util.ArrayList;
import java.util.List;

public class ContactMockedData {

    private List<Contact> contacts;
    //hardcoded data
    //singleton class for persisted changes
    private static ContactMockedData instance = null;
    public static ContactMockedData getInstance() {
        if (instance == null) {
            instance = new ContactMockedData();
        }
        return instance;
    }

    //constructor - single instance
    public ContactMockedData(){
        contacts = new ArrayList<Contact>();
        contacts.add(new Contact(1, "Iris", "5196977824"));
        contacts.add(new Contact(2, "Bob", "5145879902"));
        contacts.add(new Contact(3, "Peter", "51965409981"));
    }


    //get a list of contacts
    public List<Contact> fetchContacts() {
        return contacts;
    }

    //search contact by id
    public Contact getContactById(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    //search contact by name
    public Contact getContactByName(String name) {
        for (Contact c : contacts){
            if(c.getName() == name){
                return c;
            }
        }
        return null;
    }

    //create contact
    public Contact createContact (int id, String name, String mobile){
        Contact newContact = new Contact(id, name, mobile);
        contacts.add(newContact);
        return newContact;
    }

    //update contact
    public Contact updateContact(int id, String name, String mobile){
        for(Contact c: contacts){
            if(c.getId() == id){
                int contactIndex = contacts.indexOf(c);
                c.setName(name);
                c.setMobile(mobile);
                contacts.set(contactIndex, c);
                return c;
            }
        }
        return null;

    }

    //delete contact
    public boolean deleteContact(int id){
        int contactIndex = -1;
        for(Contact c: contacts){
            if(c.getId() == id){
                contactIndex = contacts.indexOf(c);
                continue;
            }
        }
        if(contactIndex > -1){
            contacts.remove(contactIndex);
        }
        return true;
    }

}
