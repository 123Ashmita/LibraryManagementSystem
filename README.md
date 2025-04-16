# Library Management System  <br>
A simple console-based Java application that allows users to manage books and patrons in a library. This includes adding books, adding patrons, borrowing and returning books, and getting all data.
<br>
#  Features   <br>
1.Add books and patrons   <br>
2.Borrow and return books  <br>
3.View all books and patrons  <br>
4.View books borrowed by patrons <br>


<br>

# Project Structure  <br>

LibraryManagementSystem/  <br>
│    <br> 
├── com/  <br>
│   └── app/   <br>
│       ├── LibraryManagementSystem.java   <br>
│       ├── Book.java   <br>
│       └── Patron.java   <br>
└── README.md   <br>


-----Sample-----
When the program runs, you'll see a menu like this:  <br>

Welcome to the library management system  <br>
1. Add Book  <br>
2. Add Patron  <br>
3. List all Books  <br>
4. List all Patrons  <br>
5. Boorow Book  <br>
6. Return Book  <br>
7. Borrowed book by patrons  <br>
8. Exit  <br>

Example steps:   <br>

Choose 1 to add a book.  <br>
Choose 2 to add a patron.  <br>
Choose 5 to borrow a book.   <br>
Choose 6 to return it.  <br>

* Notes   <br>
1.Each patron can borrow multiples book at a time.  <br>
2.Book availability is checked before borrowing.   <br>
3.Books will borrowed by only one patrons at a time. <br>

<p>So this is one to many relationship table</p>
<br>


  Github clone - https://github.com/123Ashmita/LibraryManagementSystem   <br>
  select master branch and able to see my project   <br>

  I have updates this code before that i am not using patron id and book  id and now i am using patron id and book id to uniquely identify books and patrons.
