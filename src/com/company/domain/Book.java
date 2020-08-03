package com.company.domain;

import java.util.Objects;

public class Book {
    private static int incId = 1;
    private int id = incId++;
    private String title;
    private String description;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String title, String description, double price, String author) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
    }

    public Book(int id, String title, String description, double price, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
