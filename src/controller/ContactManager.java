package controller;

import moder.Contact;
import regex.EmailExample;
import storage.ContactFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private static ContactManager contactManager;
    private List<Contact> contactList = new ArrayList<>();
    private  ContactFile contactFile = ContactFile.getInstance();


    private ContactManager(){}

    public static ContactManager getInstance(){
        if(contactManager==null){
            contactManager = new ContactManager();
        }
        return contactManager;
    }
    public int findByTelePhone(String phone){
        for (Contact a: contactList) {
            if(a.getPhoneNum().equalsIgnoreCase(phone)){
               return contactList.indexOf(a);
            }
        }
        return -1;
    }
    public void showList(){
        for (Contact a: contactList) {
            System.out.println(a);
        }
    }
    public void insertPhone(Contact o) throws IOException {
        contactList.add(o);
        contactFile.fileWriter(contactList);
    }
    public void remove(String telePhone) throws IOException {
        int index = findByTelePhone(telePhone);
        contactList.remove(index);
        contactFile.fileWriter(contactList);
    }
    public void edit(String telePhone, Contact o) throws IOException {
        int index = findByTelePhone(telePhone);
        contactList.set(index,o);
        contactFile.fileWriter(contactList);
    }
    public Contact findByName(String name){
        for (Contact a: contactList) {
            if(a.getFullName().equalsIgnoreCase(name)){
                return a;
            }
        }
        return null;
    }
    public boolean checkByName(String name){
        boolean check = false;
        for (Contact a:contactList) {
            if(a.getFullName().equalsIgnoreCase(name)){
                 check = true;
            }
        }
        return check;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ContactFile getContactFile() {
        return contactFile;
    }

    public void setContactFile(ContactFile contactFile) {
        this.contactFile = contactFile;
    }
}
