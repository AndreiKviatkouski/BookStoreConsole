package com.company.service;

import com.company.domain.Address;
import com.company.service.exception.AddressException;

public interface AddressService {
    // TODO: 15.08.2020 Реализовать impl AddressAction
    // TODO: 15.08.2020 Реализовать AddressValidator
    // TODO: 15.08.2020 Реализовать набор исключений для сервиса и storage

    boolean save(Address address);

    int updateHomeById(int home, int id) throws AddressException;
    String updateStreetById(String street, int id) throws AddressException;

    void remove(int id);
    void remove(Address address);

    Address getById(int id) throws AddressException;
    Address[] getAll();
    Address[] getAllByHome(int home) throws AddressException;
    Address[] getAllByStreet(String street) throws AddressException;
}
