package com.app;

import java.util.Scanner;

public class LibraryManagementSystem {
    private final int maxB = 100;  
    private final int maxP = 50; 
    Book[] books = new Book[maxB];
    Patron[] patrons = new Patron[maxP];
    private int bookCount = 0;
    private int patronCount = 0;

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
        	System.out.println("---------------------------------------");
            System.out.println("Welcome to the library management system");
            System.out.println("1. Add Book");
            System.out.println("2. Add Patron");
            System.out.println("3. List all Books");
            System.out.println("4. List all Patrons");
            System.out.println("5. Boorow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Borrowed book by patrons");
            System.out.println("8. Exit");
            System.out.println("---------------------------------------");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            switch (choice) {
            case 1: sc.nextLine();
                    System.out.println("Enter book title:");
                    String title = sc.nextLine();
                    System.out.println("Enter book author:");
                    String author = sc.nextLine();
                    lms.addBook(title, author);
                    System.out.println("Book added successfully.");
                    break;

           case 2:  sc.nextLine();
                    System.out.println("Enter patron name:");
                    String name = sc.nextLine();
                    lms.addPatron(name);
                    System.out.println("Patron added successfully.");
                    break;
                    
           case 3:  lms.listBooks();
                    break;
                    
           case 4:  lms.listPatrons();
                    break;
                    
           case 5:  sc.nextLine();
                    System.out.println("Enter patron name:");
                    name = sc.nextLine();
                    System.out.println("Enter book title:");
                    title = sc.nextLine();
                    lms.borrowBook(name, title);
                    break;
                   
           case 6:  sc.nextLine();
                    System.out.println("Enter patron name:");
                    name = sc.nextLine();
                    System.out.println("Enter book title:");
                    title = sc.nextLine();
                    lms.returnBook(name, title);
                    break;
                    
           case 7:  lms.borrowedByPatrons();
                    break;

           case 8:  System.out.println("Thank you for using this LMS");
                    sc.close();
                    return;
                 
           default:  System.out.println("Invalid option");
                     break;
                    
            }
        }
    }

	private void borrowedByPatrons() {
		System.out.println("List of Books Borrowed By Patrons:");
		for(int i=0;i<patronCount;i++) {
			Patron p=patrons[i];
			System.out.print(p.getName() + " has ");
			if(p.getBorrowedBook()!=null) {
				System.out.println("borrowed "+p.getBorrowedBook().getTitle()+" book");
			} else {
				System.out.println("not borrowed any book");
			}
		}
	}

	private void addBook(String title, String author) {
        if (bookCount >= maxB) {
            System.out.println("Book limit reached.");
            return;
        }
        books[bookCount++] = new Book(title,author);
    }

    private void addPatron(String name) {
        if (patronCount >= maxP) {
            System.out.println("Patron limit reached.");
            return;
        }
        patrons[patronCount++] = new Patron(name);
    }

    public void borrowBook(String patronName, String bookTitle) {
    	Patron patron =null;
    	for(int i=0;i<patronCount;i++) {
    		if(patrons[i].getName().equals(patronName)) {
    			patron=patrons[i];
    			break;
    		}
    	}	
    	if(patron==null) {
    	   System.out.println("patron not found");
    	   return;  		
    	}
    	Book book=null;
    	for(int i=0;i<bookCount;i++) {
    		if(books[i].getTitle().equals(bookTitle)) {
    			book=books[i];
    			break;
    		}
    	}
    	if(book==null) {
    		System.out.println("book not found");
    		return;
    	}
    	 if (book.isAvailable()) {
             patron.borrowBook(book);
             System.out.println("Book borrowed successfully.");
         } else {
             System.out.println("Sorry! Book is already borrowed by someone else.");
         }
        }


    public void returnBook(String patronName, String bookTitle) {  
    	Patron patron=null;
    	for(int i=0;i<patronCount;i++) {
    		if(patrons[i].getName().equals(patronName)) {
    			patron=patrons[i];
    			break;
    		}
    	}
    	if(patron==null) {
    		System.out.println("patron not exist");
    		return;
    	}
    	patron.returnBook();
    	
    }
    
    public void listBooks() {
    	System.out.println("---------Books list---------");
    	for(int i=0;i<bookCount;i++) {
    		books[i].printBooks();
    	}
    	System.out.println("-------------------------------");
    }
    private void listPatrons() {
    	System.out.println("---------Patrons list---------");
    	for(int i=0;i<patronCount;i++) {
    		patrons[i].printPatrons();
    	}
    	System.out.println("-------------------------------");		
	}
}
