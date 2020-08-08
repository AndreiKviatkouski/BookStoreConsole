package com.company.domain;

import java.util.Objects;

public class Author {

    //JavaBean

    // TODO: 07.08.2020 Реализовать AuthorAction
    // TODO: 07.08.2020 Реализовать AuthorValidator
    // TODO: 07.08.2020 Доавить Author menu in ConsoleApplication

    // TODO: 07.08.2020 Повторить Exceptions

    private static int incId = 1;
    private int id = incId++;

    private String fullName;

    public Author() {
    }

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public Author(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(fullName, author.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
