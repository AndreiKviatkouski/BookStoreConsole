package com.company.storage;

import com.company.domain.Address;
import com.company.domain.Store;

import java.util.Arrays;

public class StoreStorageImpl implements StoreStorage {
    private static Store[] stores = new Store[5];
    private static AddressStorage addressStorage = new AddressStorageImpl();

    static {
        stores[0] = new Store(1, "BookStore#1", addressStorage.getById(1));
    }

    @Override
    public boolean save(Store store) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) {
                stores[i] = store;
                break;
            }
        }
        return false;
    }

    @Override
    public String update(String newTitle, int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getId() == id) {
                String title = stores[i].getTitle();
                stores[i].setTitle(newTitle);
                return title;
            }
        }
        return null;
    }

    @Override
    public Address update(Address address, int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getId() == id) {
                Address addressNew = stores[i].getAddress();
                stores[i].setAddress(address);
                return addressNew;
            }
        }
        return null;
    }

    @Override
    public Store delete(int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getId() == id) {
                Store old = stores[i];
                for (int j = i; j < stores.length; j++) {
                    stores[i] = stores[j + 1];
                }
                return old;
            }
        }
        return null;
    }

    @Override
    public Store delete(Store store) {
        for (int i = 0; i < stores.length; i++) {
            Store old = stores[i];
            for (int j = i; j < stores.length; j++) {
                stores[i] = stores[j + 1];
                return old;
            }
        }
        return null;
    }

    @Override
    public Store[] getAll() {
        int count = 0;
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) {
                count++;
            }
        }
        return Arrays.copyOf(stores, count);
    }


    @Override
    public Store get(String title) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getTitle().equals(title)) {
                return stores[i];
            }
        }
        return null;
    }

    @Override
    public Store get(int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getId() == id) {
                return stores[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getId() == id) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String title) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getTitle().equals(title)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(Store store) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i] == store) {
                return true;
            }

        }
        return false;
    }
}
