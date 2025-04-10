package com.app;

public class Patron {
    private String name;
    private Book borrowedbook;

    public Patron(String name) {
        this.name = name;
        this.borrowedbook = null;
    }

    public String getName() {
        return name;
    }

    public Book getBorrowedBook() {
        return borrowedbook;
    }

    public void borrowBook(Book book) {
    	 if (this.borrowedbook == null) {
             this.borrowedbook = book;
             book.setAvailable(false); 
         } else {
             System.out.println(this.name + " already has a borrowed book: " + this.borrowedbook.getTitle());
         }
    }

    public void returnBook() {
    	 if (this.borrowedbook != null) {
             this.borrowedbook.setAvailable(true);  
             System.out.println(this.name + " has returned the book: " + this.borrowedbook.getTitle());
             this.borrowedbook = null;  
         } else {
             System.out.println(this.name + " has no book to return.");
         }
    }

	public void printPatrons() {
		System.out.println("patrons are "+name);
	}
}
