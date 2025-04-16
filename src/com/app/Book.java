package com.app;

public class Book {
	private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookid,String title, String author) {
    	this.bookId=bookid;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    public int getBookId() {
    	return bookId;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

	public void printBooks() {
	  System.out.println("Book id "+this.bookId+" || "+this.title+" by "+this.author+" ");
	}
}
