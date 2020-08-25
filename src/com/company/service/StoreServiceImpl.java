package com.company.service;

import com.company.domain.Address;
import com.company.domain.Store;
import com.company.console.exception.StorageException;
import com.company.storage.StoreStorage;
import com.company.storage.StoreStorageImpl;

public class StoreServiceImpl implements StoreService {
    private StoreStorage storeStorage = new StoreStorageImpl();

    @Override
    public boolean save(Store store) {
        if (storeStorage.contains(store)) {
            return false;
        }
        storeStorage.save(store);
        return true;
    }

    // TODO: 20.08.2020 impl. StoreServiceImpl
    // TODO: 20.08.2020 impl. StoreAction and StoreValidator
    @Override
    public String update(String newTitle, int id) throws StorageException {
        if (storeStorage.contains(id)) {
            storeStorage.update(newTitle, id);
        }
        throw new StorageException("Could not find title with ID: " + id);

    }

    @Override
    public Address update(Address address, int id) throws StorageException {
        if (storeStorage.contains(id)){
            storeStorage.equals(address);
        }
        throw  new StorageException("Could not find address with ID: " + id);
    }

    @Override
    public Store delete(int id) throws StorageException {
        if (storeStorage.contains(id)){
            storeStorage.delete(id);
        }
        throw new StorageException("Could not find ID: " + id);
    }

    @Override
    public Store delete(Store store) throws StorageException {
        if (storeStorage.contains(store)){
            storeStorage.delete(store);

        }
        throw new StorageException("Could not find store: " + store);
    }

    @Override
    public Store[] getAll() {
        return storeStorage.getAll();
    }

    @Override
    public Store get(String title) throws StorageException {
        if (storeStorage.contains(title)){
            return storeStorage.get(title);
        }
        throw new StorageException("Could not find title: " + title);
    }

    @Override
    public Store get(int id) throws StorageException {
        if (storeStorage.contains(id)){
            return storeStorage.get(id);
        }
        throw new StorageException("Could not find ID: " + id);
    }
}
