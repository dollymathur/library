package com.example.library.model;

import java.util.List;

public class BookIssue {
    User user;
    List<BookCopy> bookCopies;

    public BookIssue(User user, List<BookCopy> bookCopies) {
        this.user = user;
        this.bookCopies = bookCopies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    @Override
    public String toString() {
        return "BookIssue{" +
                "user=" + user +
                ", bookCopies=" + bookCopies +
                '}';
    }
}
