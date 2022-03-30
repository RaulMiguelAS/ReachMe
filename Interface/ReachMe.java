package Interface;

import java.util.Scanner;
import Logica.Rede;


public class ReachMe {
      static Scanner scanner = new Scanner(System.in);
      static Rede conta = new Rede();

    public static void main(String[] args) {
        byte op = 1;

        do {
            System.out.println("");
            System.out.println("  ██████╗ ███████╗ █████╗  ██████╗██╗  ██╗███╗   ███╗███████╗");
            System.out.println("  ██╔══██╗██╔════╝██╔══██╗██╔════╝██║  ██║████╗ ████║██╔════╝");
            System.out.println("  ██████╔╝█████╗  ███████║██║     ███████║██╔████╔██║█████╗ ");
            System.out.println("  ██╔══██╗██╔══╝  ██╔══██║██║     ██╔══██║██║╚██╔╝██║██╔══╝  ");
            System.out.println("  ██║  ██║███████╗██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗");
            System.out.println("  ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
            System.out.println("             {ReachMe - a UNICAP Social Media}                  ");
            menu1();
            op = scanner.nextByte();

            switch (op) {
                case 1:
                    conta.creatAccount();
                    //conta.String();
                    break;
                case 2:
                   String email = conta.logIn();
                    welcome(email);
                    break;
                case 0:
                    System.out.println("See you soon.");
                    break;
                default:
                    System.out.println("Insert a valid option.");
                    break;
            }
        } while (op != 0);

    }

    public static void menu1() {
        System.out.println("");
        System.out.println("  ========================================================= ");
        System.out.println("        {1} CREATE ACCOUNT ~ {2} LOGIN ~ {0} Exit");
        System.out.print("                     Choose an option: ");
    }

    public static void welcome(String email) {
        String username = conta.getUser(email);
 
        System.out.println("");
        System.out.println("  ██████╗ ███████╗ █████╗  ██████╗██╗  ██╗███╗   ███╗███████╗");
        System.out.println("  ██╔══██╗██╔════╝██╔══██╗██╔════╝██║  ██║████╗ ████║██╔════╝");
        System.out.println("  ██████╔╝█████╗  ███████║██║     ███████║██╔████╔██║█████╗ ");
        System.out.println("  ██╔══██╗██╔══╝  ██╔══██║██║     ██╔══██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("  ██║  ██║███████╗██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗");
        System.out.println("  ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
        System.out.println("             {ReachMe - Welcome " + username + "}                 ");
    }

    public void menuOnline() {
        System.out.println("");
        System.out.println("  ========================================================= ");
        System.out.println("     {1} EDIT ACCOUNT ~ {2} ADD FRIEND ~ {3} SEND MENSAGE");
        System.out.println("                         {0} LOGOUT                       ");
        System.out.print("                         Choose an option: ");
    }

    public void online(){
        Scanner s = new Scanner(System.in);
        byte op = 1;
 
        do {
            op = s.nextByte();
            switch (op)  {
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("to Implement");
                    break;
                case 3:
                    System.out.println("");
                    break;
            
                default:
                    System.out.println("Insert a valid option");
                    break;
            }
           
        } while ( op!=0 );
        
    }


    
}