package com.company.service;

import com.company.domain.Address;
import com.company.console.exception.AddressException;
import com.company.storage.AddressStorage;
import com.company.storage.AddressStorageImpl;

public class AddressServiceImpl implements AddressService {
    AddressStorage addressStorage = new AddressStorageImpl();

    @Override
    public boolean save(Address address) {
        if (addressStorage.contains(address)) {
            return false;
        }
        addressStorage.save(address);
        return false;
    }

    @Override
    public int updateHomeById(int home, int id) throws AddressException {
        if (addressStorage.contains(id)) {
            return addressStorage.updateHomeById(home, id);
        }
        throw new AddressException("Could not find home with ID: " + id);
    }

    @Override
    public String updateStreetById(String street, int id) throws AddressException {
        if (addressStorage.contains(id)) {
            return addressStorage.updateStreetById(street, id);
        }
        throw new AddressException("Could not find street with ID: " + id);
    }

    @Override
    public void remove(int id) {
        if (addressStorage.contains(id)) {
            addressStorage.remove(id);
        }

    }

    @Override
    public void remove(Address address) {
        if (addressStorage.contains(address)) {
            addressStorage.remove(address);
        }

    }

    @Override
    public Address getById(int id) throws AddressException {
        if (addressStorage.contains(id)) {
            addressStorage.getById(id);
        }
        throw new AddressException("Could not find ID: " + id);
    }

    @Override
    public Address[] getAll() {
        return addressStorage.getAll();
    }


    @Override
    public Address[] getAllByHome(int home) throws AddressException {
       if (addressStorage.contains(home)){
           return addressStorage.getAllByHome(home);
       }
        throw new AddressException("Could not find home: " + home);
    }

    @Override
    public Address[] getAllByStreet(String street) throws AddressException {
        if (addressStorage.contains(street)) {
            return addressStorage.getAllByStreet(street);
        }
        throw new AddressException("Could not find street: " + street);
    }
}

