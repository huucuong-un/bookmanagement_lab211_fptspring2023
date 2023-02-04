/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Admin
 */
public class Book {
    private String bookID;
    private String bookName;
    private double bookPrice;
    private int quantity;
    private String publisherID;
    private String statusFields; 
   

    public Book(String bookID, String bookName, double bookPrice, int quantity, String publisherID, String statusFields) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.publisherID = publisherID;
        this.statusFields = statusFields;
    }

    public Book() {
        
    }
    
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }

    public String getStatusFields() {
        return statusFields;
    }

    public void setStatusFields(String statusFields) {
        this.statusFields = statusFields;
    }

   
    
  

    @Override
    public String toString() {
        return String.format("%-6s | %-30s | %-7.1f | %8d | %-10s | %-15s\n", bookID, bookName, bookPrice, quantity, publisherID, statusFields);
    }
    
    
    
}
