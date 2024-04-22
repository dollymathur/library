package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BookCopy;
import com.example.library.model.Rack;
import com.example.library.model.User;
import com.example.library.repository.book.BookRepository;
import com.example.library.repository.library.LibraryRepository;
import com.example.library.repository.rack.RackRepository;

public class LibraryService {

    BookRepository bookRepository;
    LibraryRepository libraryRepository;
    RackRepository rackRepository;

    public LibraryService(BookRepository bookRepository, LibraryRepository libraryRepository, RackRepository rackRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        this.rackRepository = rackRepository;
    }

    public void issueBook(User user, BookCopy bookCopy) {
        libraryRepository.issueBook(user, bookCopy);
    }

    public void returnBook(User user, BookCopy bookCopy) {
        libraryRepository.returnBook(user, bookCopy);
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void addRack(Rack rack) {
        rackRepository.addRack(rack);
    }

    public void addBookInRack(BookCopy bookCopy) {
        rackRepository.addBookInRack(bookCopy);
    }

    public void showIssuedBooksByUserId(int userId) {
        libraryRepository.showIssuedBooksByUserId(userId);
    }

    public void removeBookCopy(BookCopy bookCopy) {
        bookRepository.removeBookCopy(bookCopy);
    }

    public void showEverything() {
        libraryRepository.showIssuedBooks();
        rackRepository.showRacks();
        bookRepository.showBooks();
    }
}
