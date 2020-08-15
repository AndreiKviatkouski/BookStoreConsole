package com.company.service;

import com.company.domain.Address;

public interface AddressService {
    // TODO: 15.08.2020 Реализовать impl AddressAction
    // TODO: 15.08.2020 Реализовать AddressValidator
    // TODO: 15.08.2020 Реализовать набор исключений для сервиса и storage

    boolean save(Address address);

    int updateHomeById(int home, int id);
    String updateStreetById(String street, int id);

    void remove(int id);
    void remove(Address address);

    Address getById(int id);
    Address[] getAll();
    Address[] getAllByHome(int home);
    Address[] getAllByStreet(String street);
}
