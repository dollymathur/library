package com.example.library;


import com.example.library.model.Book;
import com.example.library.model.BookCopy;
import com.example.library.model.Rack;
import com.example.library.model.User;
import com.example.library.repository.book.BookRepository;
import com.example.library.repository.library.LibraryRepository;
import com.example.library.repository.rack.RackRepository;
import com.example.library.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryApplication {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        RackRepository rackRepository = new RackRepository();
        LibraryRepository libraryRepository = new LibraryRepository(rackRepository, bookRepository);
        LibraryService libraryService = new LibraryService(bookRepository, libraryRepository, rackRepository);

        List<BookCopy> bookCopies = new ArrayList<>();
        bookCopies.add(new BookCopy(1, 1));
        bookCopies.add(new BookCopy(1, 2));
        Book book1 = new Book(1, "Book1", "Author1", "Publisher1", bookCopies);
        libraryService.addBook(book1);

        bookCopies = new ArrayList<>();
        bookCopies.add(new BookCopy(2, 1));
        bookCopies.add(new BookCopy(2, 2));
        Book book2 = new Book(2, "Book2", "Author2", "Publisher2", bookCopies);
        libraryService.addBook(book2);

        libraryService.addRack(new Rack(1, 2, new ArrayList<>()));
        libraryService.addRack(new Rack(2, 2, new ArrayList<>()));
        libraryService.addRack(new Rack(3, 2, new ArrayList<>()));
        libraryService.addRack(new Rack(4, 2, new ArrayList<>()));

        libraryService.addBookInRack(new BookCopy(1, 1));
        libraryService.addBookInRack(new BookCopy(1, 2));
        libraryService.addBookInRack(new BookCopy(2, 1));
        libraryService.addBookInRack(new BookCopy(2, 2));
        System.out.println("--------------------------------------------------");
        libraryService.showEverything();
        System.out.println("--------------------------------------------------");
        libraryService.issueBook(new User(1, "User1"), new BookCopy(1, 1));
        libraryService.issueBook(new User(2, "User2"), new BookCopy(1, 1));
        libraryService.issueBook(new User(2, "User2"), new BookCopy(1, 2));
        libraryService.issueBook(new User(2, "User2"), new BookCopy(1, 3));
        libraryService.issueBook(new User(1, "User2"), new BookCopy(2, 2));
        System.out.println("--------------------------------------------------");
        libraryService.showEverything();
        System.out.println("--------------------------------------------------");
        libraryService.returnBook(new User(1, "User1"), new BookCopy(1, 1));
        System.out.println("--------------------------------------------------");
        libraryService.showEverything();
        System.out.println("--------------------------------------------------");
        libraryService.showIssuedBooksByUserId(1);
        System.out.println("--------------------------------------------------");
        libraryService.removeBookCopy(new BookCopy(1, 5));
        System.out.println("--------------------------------------------------");
        libraryService.showEverything();
    }
}
