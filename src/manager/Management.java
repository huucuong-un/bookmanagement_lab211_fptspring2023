/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import object.Book;
import object.Publisher;

/**
 *
 * @author Admin
 */
public class Management {

    private Scanner sc = new Scanner(System.in);
    private List<Publisher> pList;
    private List<Book> bList;

    public Management() {
        pList = new ArrayList<>();
        bList = new ArrayList<>();

    }

    //Publisher
    public void addPublisher() throws IOException {

        String id, name;
        String phoneNumber;

        id = Validation.getID("Enter Publisher ID: ", 1, pList, "ID need to be unique and has pattern “Pxxxxx”, with xxxxx is five digits");

        name = Validation.getName("Enter Publisher's Name: ", "Name's length in range 5 to 30 characters!!!");

        phoneNumber = Validation.getPhoneNumber("Enter Phone Number: ", "Invalid phone number\nPhone number must be in rang 0 -9 and has 10-12 length number", pList);

        pList.add(new Publisher(id, name.toUpperCase(), phoneNumber));

        
        this.saveToFile();
        pList.removeAll(pList);
        

    }

    public void deletePublisher() {
        String id;
        String saving = null;

        id = Validation.getID("ID of publisher you want to remove: ", 2, pList, "Publisher’s Id does not exist, Deletete failed");
        
        for (Publisher x : pList) {

            if (x.getId().equals(id)) {
                saving = id;
                pList.remove(x);
                this.saveToFile();
                break;
               
                

            }
        }
   

      this.saveToFile();
      //this.saveToBookFile();
        pList.removeAll(pList);
        
        
        

    }

    public void display() throws IOException {
        pList.removeAll(pList);
        this.loadFromFile();

        System.out.println("ID     | Name                           | Phone      ");

        Collections.sort(pList, new Comparator<Publisher>() {
            @Override
            public int compare(Publisher o1, Publisher o2) {
                if (o1.getName().compareTo(o2.getName()) != 0);
                return o1.getName().compareTo(o2.getName());

            }
        });

        for (Publisher x : pList) {
            System.out.println(x);
        }
    }

    public void saveToFile() {
        try {
            File f = new File("Publisher.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Publisher x : pList) {
                bw.write(x.toString());
            }

            bw.close();
            fw.close();
            System.out.println("Succesfully!!!!!!!!!!");

        } catch (IOException e) {
           
            System.err.println("\n\nFailed!!!!!!!\n");
        }

    }

    public void loadFromFile() throws IOException, FileNotFoundException {
        File f = new File("Publisher.txt");

        FileReader fr = new FileReader(f);

        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String[] data = line.split("[|]");
            String id = data[0].trim(); //format de doc
            String name = data[1].trim();
            String phone = data[2].trim();

            pList.add(new Publisher(id, name, phone));

        }

        fr.close();
        br.close();
    }

    //Book
    public void addBook() throws IOException {
        this.loadFromBookFile();

        String bookId, name, publisherID, status;
        double price;
        int quantity;

        bookId = Validation.getBookID("Enter Book ID: ", 1, bList, "ID need to be unique and has pattern “Bxxxxx”, with xxxxx is five digits");

        name = Validation.getBookName("Enter Book's Name: ", 1);

        price = Validation.getDouble("Enter price: ", 0, 999999999);

        quantity = Validation.getInt("Enter quantity: ", 0, 999999999);

        publisherID = Validation.getID("Enter publisher ID: ", 2, pList, "Not exist");

        status = Validation.getBookStatus("Enter Status for book (A for Available) (N for Not Available): ", "Please enter A or N: ", 1);

        bList.add(new Book(bookId, name, price, quantity, publisherID, status));

        

        this.saveToBookFile();
        bList.removeAll(bList);
       

    }

    public void saveToBookFile() {
        try {
            File f = new File("Book.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Book x : bList) {
                bw.write(x.toString());
            }

            bw.close();
            fw.close();
            System.out.println("Successsss!!!!!");

        } catch (Exception e) {
            System.err.println("\n\nSave failed!!!.\n");
            
        }
    }
    
   

    public void loadFromBookFile() throws FileNotFoundException, IOException {
        File f = new File("Book.txt");

        FileReader fr = new FileReader(f);

        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String[] data = line.split("[|]");
            String bookId = data[0].trim(); //format de doc
            String bookName = data[1].trim();
            double bookPrice = Double.parseDouble(data[2].trim());
            int bookQuantity = Integer.parseInt(data[3].trim());
            String bookPublisherID = data[4].trim();
            String bookStatus = data[5].trim();

            bList.add(new Book(bookId, bookName, bookPrice, bookQuantity, bookPublisherID, bookStatus));

        }

        fr.close();
        br.close();

    }
    
    

    public void displayBook() throws IOException {
        
        bList.removeAll(bList);
        this.loadFromBookFile();


        System.out.println("");
        for (int i = 0; i < bList.size() - 1; i++) {
            for (int j = i + 1; j < bList.size(); j++) {
                if (bList.get(i).getQuantity() < bList.get(j).getQuantity()) {

                    Collections.swap(bList, i, j);

                } else if (bList.get(i).getQuantity() == bList.get(j).getQuantity()) {
                    if (bList.get(i).getBookPrice() > bList.get(j).getBookPrice()) {
                        Collections.swap(bList, i, j);
                    }
                }
            }
        }

        System.out.println("BookID     Name                          Prices     Quantity   Subtotal     Publisher's Name    Status   ");
        for (Book x : bList) {
            System.out.printf("%-6s | %-30s | %-7.1f | %8d | %-10.1f | %-15s | %-15s\n", x.getBookID(), x.getBookName(), x.getBookPrice(), x.getQuantity(), (x.getBookPrice() * x.getQuantity()), Validation.pName(x.getPublisherID(), pList, bList), x.getStatusFields());

        }
    }

    public void searchBook() {
        

        String bookSearchByName;
        String bookSearchByPId;
        int count = 0;
        int countt = 0;
        
        for (Book b : bList) {
            System.out.println(b);
        }

        do {
            System.out.print("Enter the name of book you want to search: ");
            bookSearchByName = sc.nextLine();
            
            bookSearchByPId = Validation.getID("Enter PublisherID: ", 3, pList, "Error format");
           
            for (Book b : bList) {
                
                if(b.getBookName().contains(bookSearchByName) && bookSearchByPId.equals(b.getPublisherID())) {
                    System.out.println(b);
                  
                } else if (b.getBookName().contains(bookSearchByName) && bookSearchByPId.equals("")) {
                    System.out.println(b);

                } else if (bookSearchByName.equals("") && bookSearchByPId.equals("")) {
                    System.out.println(b);
                    
                } else if (bookSearchByName.equals("") && bookSearchByPId.equals(b.getPublisherID())) {
                    System.out.println(b);
                  
                } else if (b.getBookName().contains(bookSearchByName) &&  !bookSearchByPId.equals(b.getPublisherID())) {
                    countt++;
                }
                    
                count++;
                
               
                
                
                

            }

            if (count == 0 || countt != 0) {
                System.err.println("\n\nHave no any book!!!");
                System.err.println("\n\nPlease enter again");
            } else {
                break;
            }
            

        } while (true);

    }

    public void updateBook() throws IOException {
       

        String bookUpdate;
        String bookNameUpdate, bookPublisherIDUpdate, bookStatusUpdate;
        String bookPriceUpdate;
        String bookQuantityUpdate;

        int count = 0;

        do {
            System.out.print("Enter Book ID to update: ");
            bookUpdate = sc.nextLine();

            for (Book b : bList) {
                if (bookUpdate.equals(b.getBookID())) {
                    System.out.println(b + "\n");

                    bookNameUpdate = Validation.getBookName("Update book name: ", 2);
                    if (bookNameUpdate.equals("")) {
                        b.setBookName(b.getBookName());
                    } else {
                        b.setBookName(bookNameUpdate);
                    }

                    do {
                        System.out.print("Update book price: ");
                        bookPriceUpdate = sc.nextLine();
                        if (bookPriceUpdate.equals("")) {
                            b.setBookPrice(b.getBookPrice());
                            break;
                        } else if (bookPriceUpdate.matches("^([0-9]){1,15}$") || bookPriceUpdate.matches("^([0.00-9.99]){1,15}$")) {
                            b.setBookPrice(Double.parseDouble(bookPriceUpdate));
                            break;
                        } else {
                            System.err.println("Invalid");
                        }
                    } while (true);

                    do {
                        System.out.print("Update book quantity: ");
                        bookQuantityUpdate = sc.nextLine();
                        if (bookPriceUpdate.equals("")) {
                            b.setQuantity(b.getQuantity());
                            break;
                        } else if (bookQuantityUpdate.matches("^([0-9]){1,15}$")) {
                            b.setQuantity(Integer.parseInt(bookQuantityUpdate));
                            break;
                        } else {
                            System.err.println("Invalid quantity");
                        }
                    } while (true);
                    

                    bookPublisherIDUpdate = Validation.getID("Update PublisherID: ", 3, pList, "ID not found");
                    if (bookPublisherIDUpdate.equals("")) {
                        b.setPublisherID(b.getPublisherID());
                    } else {
                        b.setPublisherID(bookPublisherIDUpdate);
                    }

                   
                    bookStatusUpdate = Validation.getBookStatus("Update status: ", "Please enter a or n (Available or Not Available):  ", 2);
                    if (bookStatusUpdate.equals("")) {
                        b.setStatusFields(b.getStatusFields());
                        
                    } else {
                        b.setStatusFields(bookStatusUpdate);
                    }
                    

                    count++;

                    this.saveToBookFile();
                }
            }

            if (count == 0) {
                System.err.println("Book's Name does not exist");
            } else {
                break;
            }
        } while (true);
        bList.removeAll(bList);
        this.loadFromBookFile();

    }

    public void deleteBook() throws IOException {


        
        String id;

        id = Validation.getBookID("ID of book you want to remove: ", 2, bList, "Book’s Id does not exist, Deletete failed");

        for (Book x : bList) {

            if (x.getBookID().equals(id)) {
                    
                bList.remove(x);
                this.saveToBookFile();
               
                break;

            }
        }
        bList.removeAll(bList);
        this.loadFromBookFile();

    }

}
