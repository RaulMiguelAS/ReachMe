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
        String username = s.nextLine();
        System.out.println("========================");
        System.out.print("PASSWORD: ");
        String password = s.nextLine();
        System.out.println("========================");
        Account a = new Account(email, username, password);
        Accounts.add(a);
        
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
    public void String(){
        for(Account account : Accounts){
            System.out.println(account.getEmail());
            System.out.println(account.getUsername());
            System.out.println(account.getPassword());
        }
        
    }
    
    public boolean insert_mail(String email) {
        if (!isMail(email)) {
            return false;
        } else {
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