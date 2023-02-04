/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import static java.lang.System.err;
import java.util.List;
import java.util.Scanner;
import object.Book;
import object.Publisher;

/**
 *
 * @author Admin
 */
public class Validation {

    //input value: int, double, id
    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());

                if (min <= number ) {
                    break;
                }

                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.err.println("Enter integer number from " + min );
                System.out.println("");
            }
        }

        return number;
    }

    public static double getDouble(String msg, double min, double max) {
        double number;
        while (true) {
            try {
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());

                if (min <= number && number <= max) {
                    break;
                }

                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.err.println("Enter real number from " + min);
                System.out.println("");
            }
        }

        return number;
    }

    public static String getID(String msg, int mode, List<Publisher> pList, String error) { //GET PUBLISHER ID
       
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();

            // mode:
            // 1. input ~ id not exist
            // 2. delete ~ id must existed
            // 3. update ~ can get ""
            if (s.matches("P[0-9][0-9][0-9][0-9][0-9]")) { //"^P[0-9]{5}$"
                if ((mode == 1 && !idExist(s, pList)) || mode == 2 && idExist(s, pList)) {
                    break;
                }

                if (mode == 1 && idExist(s, pList)) {
                    System.err.println("Existed ID, please input again");

                }

                if ((mode == 2 || mode == 3)&& !idExist(s, pList)) {
                    System.err.println("Does not exist!!!");

                }

                if ((mode == 2 || mode == 3) && idExist(s, pList)) {
                    break;
                }
                
                
            } else if (s.equals("") && mode == 3) {
                break;
            } else {
                System.err.println(error);
            }
        }

        return s;
    }

    private static boolean idExist(String id, List<Publisher> pList) { //CHECK PUBLISHER ID EXIST
        for (Publisher x : pList) {
            if (x.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public static String getName(String msg, String error) {        //GET PUBLISHER NAME
        String s;
        do {
            System.out.print(msg);

            s = sc.nextLine();

            if (s.matches("^([a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*){5,30}$")) { //format tên
                return s;

            } else {
                System.err.println(error);
            }
        } while (true);

    }

    public static String getPhoneNumber(String msg, String error, List<Publisher> pList) { //VALID PHONENUMBER
        String phoneNumber;

        while (true) {
            System.out.print(msg);
            phoneNumber = sc.nextLine();

            if (!phoneExist(phoneNumber, pList) && (phoneNumber.matches("^[0-9]{10,12}$"))) {
                break;
            } else if (phoneExist(phoneNumber, pList)) {
                System.err.println("Existed phone number, please enter again");
            } else {
                System.err.println(error);
            }
        }

        return phoneNumber;

    }

    private static boolean phoneExist(String phoneNumber, List<Publisher> pList) { //CHECK PHONE EXIST
        for (Publisher x : pList) {
            if (x.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }

        return false;
    }

  

    public static String getBookID(String msg, int mode, List<Book> bList, String error) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();

            // mode:
            // 1. input ~ id not exist
            // 2. delete ~ id must existed
           
            if (s.matches("B[0-9][0-9][0-9][0-9][0-9]") ) { //"^B[0-9]{5}$"
                if ((mode == 1 && !idBookExist(s, bList)) || mode == 2 && idBookExist(s, bList)) {
                    break;
                }

                if (mode == 1 && idBookExist(s, bList)) {
                    System.err.println("Existed ID, please input again");

                }

                if (mode == 2 && !idBookExist(s, bList)) {
                    System.err.println(error);

                }
                
                

            } else {
                System.err.println(error);
            }
        }

        return s;
    }

    private static boolean idBookExist(String id, List<Book> bList) {
        for (Book x : bList) {
            if (x.getBookID().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public static String getBookStatus(String msg, String error, int mode) {
        String s;
        boolean cont = true;

        do {
            System.out.print(msg);
            s = sc.nextLine();

            if ((s.equals("a")) || (s.equals("A")) && (mode == 1 || mode == 2)) {
                s = "Available";
                cont = false;
            } else if ((s.equals("n")) || (s.equals("N")) && (mode == 1 || mode == 2)) {
                s = "Not Available";
                cont = false;
            } else if (s.equals("") && mode == 2){
                return s;
            }  else {
                System.err.println(error);
            }

        } while (cont);

        return s;

    }

    public static String getBookName(String msg, int mode) {
        String s;
        System.out.print(msg);

        //mode 1: input
        //     2: update
        do {
            s = sc.nextLine();
            

            if (s.matches("[\\s\\S]*.{5,30}") && (mode == 1 || mode == 2)) {
                break;
            } else if (s.equals("") && mode == 2) {
                break;
            } else {
                System.out.println("Book name has length 5 - 30 characters");
                System.out.print("Please enter book name again: ");
            }

        } while (true);

        return s;
    }

    public static String pName(String id, List<Publisher> pList, List<Book> bList) {
        
        String name;
        for (Publisher p: pList) {
            if (p.getId().equals(id)) {
                name = p.getName();
                return name;
            }
        }
        return null;
    }
}
