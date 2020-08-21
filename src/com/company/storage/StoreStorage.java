package com.company.storage;

import com.company.domain.Address;
import com.company.domain.Store;

public interface StoreStorage {
    boolean save(Store store);

    String update(String newTitle, int id);
    Address update(Address address, int id);

    Store delete(int id);
    Store delete(Store store);

    Store[] getAll();
    Store get(String title);
    Store get(int id);

    boolean contains(int id);
    boolean contains(String title);
    boolean contains(Store store);

}
