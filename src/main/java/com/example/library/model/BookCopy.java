package com.example.library.model;

public class BookCopy {
    int bookId;
    int copyId;
    boolean issued;

    public BookCopy(int bookId, int copyId) {
        this.bookId = bookId;
        this.copyId = copyId;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "bookId=" + bookId +
                ", copyId=" + copyId +
                ", issued=" + issued +
                '}';
    }
}
