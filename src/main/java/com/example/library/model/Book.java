package com.example.library.model;

import java.util.List;

public class Book {
    int id;
    String title;
    String author;
    String publisher;
    List<BookCopy> copies;

    public Book(int id, String title, String author, String publisher, List<BookCopy> copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", copies=" + copies +
                '}';
    }
}
