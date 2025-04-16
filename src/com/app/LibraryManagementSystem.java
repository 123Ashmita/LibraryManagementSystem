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
                    System.out.println("Enter book id:");
                    int bookid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter book title:");
                    String title = sc.nextLine();
                    if(title.isBlank()) {
                        System.out.println("Book title cannot be blank.");
                        break;
                    }
                    System.out.println("Enter book author:");
                    String author = sc.nextLine();
                    if(author.isBlank()) {
                    	System.out.println("Book Author cannot be blank.");
                        break;
                    }
                    lms.addBook(bookid,title, author);
                    break;

           case 2:  sc.nextLine();
                    System.out.println("Enter patron id:");
                    int pid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter patron name:");
                    String name = sc.nextLine();
                    if(name.isBlank()) {
                    	System.out.println("Patron name cannot be blank");
                    	break;
                    }
                    lms.addPatron(pid,name);
                    break;
                    
           case 3:  lms.listBooks();
                    break;
                    
           case 4:  lms.listPatrons();
                    break;
                    
           case 5:  sc.nextLine();
                    System.out.println("Enter patron id:");
                    pid=sc.nextInt();
                    System.out.println("Enter book id:");
                    bookid=sc.nextInt();
                    lms.borrowBook(pid,bookid);
                    break;
                   
           case 6:  sc.nextLine();
                    System.out.println("Enter patron id:");
                    pid=sc.nextInt();
                    System.out.println("Enter book id:");
                    bookid=sc.nextInt();
                    lms.returnBook(pid,bookid);
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
			if(p.getBorrowedBookCount()==0) {
				continue;
			} 
			 System.out.println(p.getName() + " has borrowed:");
		        for (int j = 0; j < p.getBorrowedBookCount(); j++) {
		            System.out.println("  - " + p.getBorrowedBooks()[j].getTitle() + " book.");
		        }			
		}
	}
	private void addBook(int bookid, String title, String author) {
        if (bookCount >= maxB) {
            System.out.println("Book limit reached.");
            return;
        }
        for(int i=0;i<bookCount;i++) {
        	if(books[i].getBookId()==bookid) {
        		System.out.println("book id already exist!! ");
        		return;
        	}
        }
        books[bookCount++] = new Book(bookid,title,author);
        System.out.println("book addedd successfully !!");
        
    }

    private void addPatron(int pid,String name) {
    	if (patronCount >= maxP) {
            System.out.println("Patron limit reached.");
             return;
 	   } 
        for(int i=0;i<patronCount;i++) { 
    	  if(patrons[i].getPid()==pid) {
  		    System.out.println("Already exist ");
  		    return;
    	}  
      }
          patrons[patronCount++] = new Patron(pid,name);
          System.out.println("Patron added successfully.");       
    }

    public void borrowBook(int pid, int bookid) {
    	Patron patron =null;
    	for(int i=0;i<patronCount;i++) {
    		if(patrons[i].getPid()==pid) {
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
    		if(books[i].getBookId()==bookid) {
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


    public void returnBook(int pid,int bookid) {  
    	Patron patron=null;
    	for(int i=0;i<patronCount;i++) {
    		if(patrons[i].getPid()==pid) {
    			patron=patrons[i];
    			break;
    		}
    	}
    	if(patron==null) {
    		System.out.println("patron not exist");
    		return;
    	}
    	patron.returnBook(bookid);  	
    }    
    public void listBooks() {
    	System.out.println("---------Books list---------");
    	for(int i=0;i<bookCount;i++) {
    		books[i].printBooks();
    	}  	
    }
    private void listPatrons() {
    	System.out.println("---------Patrons list---------");
    	for(int i=0;i<patronCount;i++) {
    		patrons[i].printPatrons();
    	}	
	}
}
