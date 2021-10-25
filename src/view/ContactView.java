package view;

import controller.ContactManager;
import moder.Contact;
import regex.EmailExample;
import storage.ContactFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ContactView {

    private  static ContactManager contactManager = ContactManager.getInstance();
    public static void main(String[] args) {
        try {
            contactManager.setContactList(ContactFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        int choice = -1;
        while (choice!=0){
            Scanner scanner = new Scanner(System.in);
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    contactManager.showList();
                    break;
                case 2:
                    Contact newC = newContact();
//                    boolean check = checkEmail(newC);
//                    while(!check){
//                        Scanner scanner1 = new Scanner(System.in);
//                        System.out.println("Email khong hop le, nhap lai!");
//                        String fixEmail = scanner1.nextLine();
//                        newC.setEmail(fixEmail);
//                        check = checkEmail(newC);
//                    }
                    try {
                        contactManager.insertPhone(newC);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    String name = inputTelePhone();
                    Contact editC = newContact();
                    try {
                        contactManager.edit(name,editC);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    String name2 = inputTelePhone();
                    try {
                        contactManager.remove(name2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    String searchName = inputName();
                    Contact contact = contactManager.findByName(searchName);
                    if(contact == null){
                        System.out.println("Lien lac khong ton tai!");
                        break;
                    }
                    System.out.println(contact);
                    break;
//                case 6:
//                    try {
//                        contactManager.setContactList(ContactFile.getInstance().fileReader());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case 7:
//                    try {
//                        try {
//                            contactManager.setContactList(ContactFile.getInstance().fileReader());
//                        } catch (ClassNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                        contactManager.getContactFile().fileWriter(contactManager.getContactList());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    break;
                case 0:
            }
        }
    }
    public static String inputTelePhone(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so dien thoai ");
        return  scanner.nextLine();
    }
    public static String inputName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten lien lac ");
        return  scanner.nextLine();
    }
    public static void showMenu(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("0. Exit!");
        System.out.println("Nhập lựa chọn của bạn: ");

    }
    public static Contact newContact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten liec lac");
        String name = input.nextLine();


        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhap nhom lien lac");
        String group = input2.nextLine();


        Scanner input3 = new Scanner(System.in);
        System.out.println("Nhap so dien thoai");
        String telePN = input3.nextLine();

        Scanner input4 = new Scanner(System.in);
        System.out.println("Nhap gioi tinh");
        String sex = input4.nextLine();


        Scanner input5 = new Scanner(System.in);
        System.out.println("Nhap dia chi");
        String add = input5.nextLine();


        Scanner input6 = new Scanner(System.in);
        System.out.println("Nhap ngay sinh");
        String birthDay = input6.nextLine();


        Scanner input7 = new Scanner(System.in);
        System.out.println("Nhap email");
        String email = input7.nextLine();

        return new Contact(telePN,group,name,sex,add,birthDay,email);
//    }
//    public static boolean checkEmail(Contact contact){
//        EmailExample emailExample = new EmailExample();
//       return emailExample.validateEmail(contact.getEmail());
    }
}
