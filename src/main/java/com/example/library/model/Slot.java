package com.example.library.model;

public class Slot {
    int bookId;
    int copyId;

    public Slot(int bookId, int copyId) {
        this.bookId = bookId;
        this.copyId = copyId;
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

    @Override
    public String toString() {
        return "Slot{" +
                "bookId=" + bookId +
                ", copyId=" + copyId +
                '}';
    }
}
