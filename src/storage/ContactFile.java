package storage;

import moder.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFile {
    private static ContactFile contactFile;

    private ContactFile() {
    }
    public static ContactFile getInstance(){
        if (contactFile == null){
            contactFile = new ContactFile();
        }
        return contactFile;
    }

    public List<Contact> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("contact.dat");


        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<Contact> list = (List<Contact>) ois.readObject();

            ois.close();
            is.close();
            return list;
        } else return new ArrayList<>();

    }


    public void fileWriter(List<Contact> contacts) throws IOException {
        FileOutputStream os = new FileOutputStream("contact.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(contacts);
        oos.close();
        os.close();
    }


}
