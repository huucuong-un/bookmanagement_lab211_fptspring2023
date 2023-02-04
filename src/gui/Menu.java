/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import manager.Management;

/**
 *
 * @author Admin
 */
public class Menu {

    public static void display() throws IOException {
        Management m = new Management();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean cont = true;
       
        m.loadFromBookFile();
         m.loadFromFile();

        do {
            System.out.println("=======PublisherManagement=======");
            System.out.println("1. Add publisher");
            System.out.println("2. Delete publisher");
            System.out.println("3. Add book");
            System.out.println("4. Searching book");
            System.out.println("5. Update book");
            System.out.println("6. Delete book");
            System.out.println("7. Print books list");
            System.out.println("8. Print publishers list");
            System.out.println("9. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            do {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Please enter a number");
                    System.out.print("Enter your choice: ");

                }
            } while (true);
            
            switch (choice) {
                case 1:

                    boolean contCase1 = true;

                    do {
                      
                        m.display();
                        m.addPublisher();
                        System.out.println("\n");
                       
                        m.display();
                        System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase1 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase1 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);

                    } while (contCase1);

                    break;
                    
                    
                    
                    

                case 2:

                    boolean contCase2 = true;

                    do {
                        
                        m.display();
                        m.deletePublisher();
                        System.out.println("\n");
                        m.display();
                        System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase2 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase2 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);

                    } while (contCase2);
                    break;
                    
                    
                    
                    

                case 3:

                    boolean contCase3 = true;
                    do {
                        m.displayBook();
                        m.addBook();
                        System.out.println("\n");
                        m.displayBook();
                        System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;
                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase3 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase3 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase3);

                    break;
                    
                    
                    
                case 4:
                    boolean contCase4 = true;
                    do {
                   
                    m.searchBook();
                    
                    System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;
                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase4 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase4 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase4);    
                    break;
                    
                    
                    
                 
                case 5: 
                    boolean contCase5 = true;
                    do {
                        m.displayBook();
                        m.updateBook();
                        
                        m.displayBook();
                        
                        System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;
                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase5 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase5 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase5);
                   
                    break;
                    
                    
                    
                    
                case 6: 
                    boolean contCase6 = true;
                    do {
                         m.displayBook();
                         m.deleteBook();
                         m.displayBook();
                         
                           
                        System.out.print("\nDo you want to go back to MENU (Y/N)?: ");
                        String s;
                        boolean cont3 = true;
                        do {
                            s = sc.nextLine();

                            if (s.equals("Y") || s.equals("y")) {
                                cont3 = false;
                                contCase6 = false;
                                break;
                            } else if (s.equals("N") || s.equals("n")) {
                                contCase6 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase6);
                   
                    break;
                    
                case 7: 
                    m.displayBook();
                    break;
                
                case 8: 
                    m.display();
                    break;
                    
                case 9:
                    cont = false;
                    System.out.println("\nGood bye. See ya!!!!!!!\n");
                    break;
                
                default:
                    System.out.println("Please enter 1 - 9");
                    

            }
        }while (cont);

    }
}
