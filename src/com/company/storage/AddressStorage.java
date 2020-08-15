package com.company.storage;

import com.company.domain.Address;
import com.company.domain.Author;
import com.company.domain.Book;

import java.math.BigDecimal;

public interface AddressStorage {
    boolean save(Address address);

    int updateHomeById(int home, int id);
    String updateStreetById(String street, int id);

    void remove(int id);
    void remove(Address address);

    Address getById(int id);
    Address[] getAll();
    Address[] getAllByHome(int home);
    Address[] getAllByStreet(String street);

    boolean contains(Address address);
    boolean contains(int id);
    boolean contains(String street);
    boolean contains(int home,int id);
}
