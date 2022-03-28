package Logica;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rede{
    private LinkedList<Account> Accounts = new LinkedList<Account>();
    Scanner s= new Scanner(System.in);


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
    public void String(){
        for(Account account : Accounts){
            System.out.println(account.getEmail());
            System.out.println(account.getUsername());
            System.out.println(account.getPassword());
        }
        
    }

    public static boolean insert_mail(String email) {
        if (!isMail(email)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isMail(String email) {
        String regex = "^(.)+@(.)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    public static boolean isDate(String date) {
        String regex = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    


    
} 