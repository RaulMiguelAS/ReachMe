package Logica;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rede{
    private static LinkedList<Account> Accounts = new LinkedList<Account>();
    static Scanner s= new Scanner(System.in);

   //Criar conta
    public void creatAccount(){
        
        System.out.println("EMAIL: ");
        String email = s.nextLine();
        while (insert_mail(email) == false) {
            System.out.println("========================");
            System.out.println("Please insert a valid email.");
            System.out.print("EMAIL: ");
            email = s.nextLine();
        }
        System.out.println("========================");
        System.out.print("USERNAME: ");
        String username = "Guest" +(1 + Math.random() * 99999999);
        username = s.nextLine();
        System.out.println("========================");
        System.out.print("PASSWORD: ");
        String password = s.nextLine();
        System.out.println("========================");
        Account a = new Account(email, username, password);
        Accounts.add(a);
        
    }
    //Edit ACCOUNT
    public void editAccount(String email){
        byte op=1;

        System.out.println("What you want to edit?");
        System.out.println("{1} Username ");
        System.out.println("{2} Password");
        System.out.println("{3} Birthdate");
        System.out.println("{4} Relationship");
        System.out.print("Choose an option: ");
        op= s.nextByte();
        switch (op) {
            case 1:
                char option = 'n';
                String newUsername = "";
                do{
                    System.out.println("enter the new username: ");
                    newUsername = s.next();
                    System.out.println(newUsername+ " Is correct? 'S' or 'N'");
                    option = s.next().charAt(0);
                }while(option!='s' && option!='S');

                for(Account account : Accounts){
                    if ((account.getEmail()).equals(email)) {
                        account.setUsername(newUsername);

                    }
                }
                break;
            case 2:
                System.out.println("to Implement.");
                break;
            case 3:
                System.out.println("to Implement.");
                break;
            case 4:
                System.out.println("to Implement.");
                break;
        
            default:
                System.out.println("Insert a valid option");
                break;
        }

    }

    // LogIn
    public String logIn() {
        System.out.println("Insert your email: ");
        String email = s.nextLine();
        checkAccount(email);
        System.out.println("========================");
        System.out.println("PASSWORD: ");
        String password = s.nextLine();
        checkPassword(password);
        return email;
    }
    //Testes
    // public void String(){
    //     for(Account account : Accounts){
    //         System.out.println(account.getEmail());
    //         System.out.println(account.getUsername());
    //         System.out.println(account.getPassword());
    //     }
        
    // }
    
    public boolean insert_mail(String email) {
        if (!isMail(email)) {
            return false;
        } else {
            for (Account account : Accounts) {
                if ((account.getEmail()).equals(email)) {
                    System.out.println("This email is already registered");
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isMail(String email) {
        String regex = "^(.)+@(.)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    //isDate aprender regex
    public boolean isDate(String date) {
        String regex = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }
    

    public int checkAccount(String emailAd) {

        int registered = searchAccount(emailAd);
        while (registered == -1) {
            System.out.println("Email not registered, try again.");
            emailAd = s.nextLine();
            registered = searchAccount(emailAd);
        }
        return registered;
    }

    public int searchAccount(String email) {
        for (Account account : Accounts) {
            if ((account.getEmail()).equals(email)) {
                return 1;
            }
        }
        return -1;
    }

    public int searchPassword(String password) {
        for (Account account : Accounts) {
            if ((account.getPassword()).equals(password)) {
                return 1;
            }
        }
        return -1;
    }


    public int checkPassword(String passwordUser) {

        int registered = searchPassword(passwordUser);
        while (registered == -1) {
            System.out.println("Invalid password, try again.");
            passwordUser = s.nextLine();
            registered = searchPassword(passwordUser);
        }
        return registered;
    }

    public String getUser(String email){
        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                return account.getUsername();
            }
        }
        return null;
    }
}