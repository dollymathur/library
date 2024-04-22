package com.example.library.repository.book;

import com.example.library.model.Book;
import com.example.library.model.BookCopy;

public class BookRepository {

    BookInventory bookInventory = new BookInventory();

    public void addBook(Book book) {
        bookInventory.books.add(book);
        System.out.println("Book with bookId: " + book.getId() + " added successfully");
    }

    public void showBooks() {
        for (Book book : bookInventory.books) {
            System.out.println(book);
        }
    }

    public void removeBookCopy(BookCopy bookCopy) {
        for (Book b : bookInventory.books) {
            if (b.getId() == bookCopy.getBookId()) {
                for (int i = 0; i < b.getCopies().size(); i++) {
                    if (b.getCopies().get(i).getCopyId() == bookCopy.getCopyId()) {
                        b.getCopies().remove(i);
                        System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getCopyId() + " removed successfully");
                        return;
                    }
                }
            }
        }
        System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getCopyId() + " not found");
    }

    public void markBookAsIssued(BookCopy bookCopy) {
        for (Book b : bookInventory.books) {
            if (b.getId() == bookCopy.getBookId()) {
                for (BookCopy bc : b.getCopies()) {
                    if (bc.getCopyId() == bookCopy.getCopyId()) {
                        bc.setIssued(true);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void markBookAsUnissued(BookCopy bookCopy) {
        for (Book b : bookInventory.books) {
            if (b.getId() == bookCopy.getBookId()) {
                for (BookCopy bc : b.getCopies()) {
                    if (bc.getCopyId() == bookCopy.getCopyId()) {
                        bc.setIssued(false);
                        break;
                    }
                }
                break;
            }
        }
    }

    public boolean checkIfValidBookCopyToBeIssued(BookCopy bookCopy) {
        for (Book b : bookInventory.books) {
            if (b.getId() == bookCopy.getBookId()) {
                for (BookCopy bc : b.getCopies()) {
                    if (bc.getCopyId() == bookCopy.getCopyId()) {
                        return !bc.isIssued();
                    }
                }
            }
        }
        return false;
    }

    public void removeBook(BookCopy bookCopy) {
        for (Book b : bookInventory.books) {
            if (b.getId() == bookCopy.getBookId()) {
                for (int i = 0; i < b.getCopies().size(); i++) {
                    if (b.getCopies().get(i).getCopyId() == bookCopy.getCopyId()) {
                        b.getCopies().remove(i);
                        break;
                    }
                }
                break;
            }
        }
    }
}
