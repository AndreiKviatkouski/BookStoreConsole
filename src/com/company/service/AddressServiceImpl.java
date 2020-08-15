package com.company.service;

import com.company.domain.Address;
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
    public int updateHomeById(int home, int id) {
        if (addressStorage.contains(id)) {
            return addressStorage.updateHomeById(home, id);
        }
        return -1;
    }

    @Override
    public String updateStreetById(String street, int id) {
        if (addressStorage.contains(id)) {
            return addressStorage.updateStreetById(street, id);
        }
        return null;
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
    public Address getById(int id) {
        if (addressStorage.contains(id)) {
            addressStorage.getById(id);
        }
        return null;
    }

    @Override
    public Address[] getAll() {
        return addressStorage.getAll();
    }


    @Override
    public Address[] getAllByHome(int home) {
       if (addressStorage.contains(home)){
           return addressStorage.getAllByHome(home);
       }
       return null;
    }

    @Override
    public Address[] getAllByStreet(String street) {
        if (addressStorage.contains(street)) {
            return addressStorage.getAllByStreet(street);
        }
       return null;
    }
}

