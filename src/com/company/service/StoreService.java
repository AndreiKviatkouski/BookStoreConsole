package com.company.service;

import com.company.domain.Address;
import com.company.domain.Store;
import com.company.service.exception.StorageException;

public interface StoreService {
    boolean save(Store store);

    String update(String newTitle, int id) throws StorageException;
    Address update(Address address, int id) throws StorageException;

    Store delete(int id) throws StorageException;
    Store delete(Store store) throws StorageException;

    Store[] getAll();
    Store get(String title) throws StorageException;
    Store get(int id) throws StorageException;
}
