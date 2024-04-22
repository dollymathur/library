package com.example.library.repository.library;

import com.example.library.model.BookCopy;
import com.example.library.model.BookIssue;
import com.example.library.model.User;
import com.example.library.repository.book.BookRepository;
import com.example.library.repository.rack.RackRepository;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    LibraryInventory libraryInventory = new LibraryInventory();
    RackRepository rackRepository;
    BookRepository bookRepository;

    public LibraryRepository(RackRepository rackRepository, BookRepository bookRepository) {
        this.rackRepository = rackRepository;
        this.bookRepository = bookRepository;
    }

    public void issueBook(User user, BookCopy bookCopy) {
        if (!bookRepository.checkIfValidBookCopyToBeIssued(bookCopy)) {
            System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getCopyId() + " can't be issued");
            return;
        }
        bookCopy.setIssued(true);
        bookRepository.markBookAsIssued(bookCopy);
        rackRepository.removeBookFromRack(bookCopy);
        for (BookIssue bookIssue : libraryInventory.bookIssues) {
            if (bookIssue.getUser().getId() == user.getId()) {
                List<BookCopy> localBookCopies = new ArrayList<>(bookIssue.getBookCopies());
                localBookCopies.add(bookCopy);
                bookIssue.setBookCopies(localBookCopies);
                System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getCopyId() + " issued successfully to user: " + user.getId());
                return;
            }
        }

        libraryInventory.bookIssues.add(new BookIssue(user, List.of(bookCopy)));
        System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getCopyId() + " issued successfully to user: " + user.getId());
        rackRepository.removeBookFromRack(bookCopy);
    }

    public void returnBook(User user, BookCopy bookCopy) {
        for (BookIssue bookIssue : libraryInventory.bookIssues) {
            if (bookIssue.getUser().getId() == user.getId()) {
                for (BookCopy bc : bookIssue.getBookCopies()) {
                    if (bc.getBookId() == bookCopy.getBookId() && bc.getCopyId() == bookCopy.getCopyId()) {
                        bc.setIssued(false);
                        break;
                    }
                }
                bookRepository.markBookAsUnissued(bookCopy);
                rackRepository.addBookInRack(bookCopy);
                return;
            }
        }
    }

    public void showIssuedBooks() {
        for (BookIssue bookIssue : libraryInventory.bookIssues) {
            System.out.println(bookIssue);
        }
    }

    public void showIssuedBooksByUserId(int userId) {
        for (BookIssue bookIssue : libraryInventory.bookIssues) {
            if (bookIssue.getUser().getId() == userId) {
                System.out.println(bookIssue);
            }
        }
    }
}
