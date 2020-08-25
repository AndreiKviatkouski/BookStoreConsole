package com.company.console.action;

import com.company.console.validator.AddressValidator;
import com.company.console.validator.StoreValidator;
import com.company.domain.Address;
import com.company.domain.Store;
import com.company.service.StoreService;
import com.company.service.StoreServiceImpl;
import com.company.console.exception.StorageException;

import static com.company.console.util.Reader.readInt;
import static com.company.console.util.Reader.readString;
import static com.company.console.util.Writer.writeString;

public class StoreAction {
    private StoreService storeService = new StoreServiceImpl();

    public void save() {
        writeString("Enter title");
        String title = readString();
        if (!StoreValidator.validTitle(title)) {
            writeString("Invalid title: " + title);
            return;
        }
        writeString("Enter street");
        String street = readString();
        if (!AddressValidator.validStreet(street)) {
            writeString("Invalid street: " + street);
            return;
        }
        writeString("Enter home number");
        int home = readInt();
        if (!AddressValidator.validHome(home)) {
            writeString("Invalid home number: " + home);
            return;
        }
        Address address = new Address(street, home);
        Store store = new Store(title, address);
        storeService.save(store);
        writeString("Store was add: " + store);
    }

    public void updateTitleById() {
        writeString("Enter id");
        int id = readInt();
        if (!StoreValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter new title");
        String title = readString();
        if (!StoreValidator.validTitle(title)) {
            writeString("Invalid title: " + title);
            return;
        }
        try {
            storeService.update(title, id);
            writeString("Store title was updated:" + title);
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }

    }

    public void updateAddressById() {
        writeString("Enter id");
        int id = readInt();
        if (!StoreValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter street");
        String street = readString();
        if (!AddressValidator.validStreet(street)) {
            writeString("Invalid street: " + street);
            return;
        }
        writeString("Enter home number");
        int home = readInt();
        if (!AddressValidator.validHome(home)) {
            writeString("Invalid home number: " + home);
            return;
        }
        Address address = new Address(street, home);
        try {
            storeService.update(address, id);
            writeString("Store  was updated:" + address);
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteById() {
        writeString("Enter id");
        int id = readInt();
        if (!StoreValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        try {
            storeService.delete(id);
            writeString("Store was deleted: " + storeService.get(id));
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteStore() {
        Store[] all = storeService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getTitle());
        }
        int i = readInt() - 1;
        Store store = all[i];
        try {
            storeService.delete(store);
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }
        writeString("Store was deleted: " + store);

    }

    public void getById() {
        writeString("Enter id");
        int id = readInt();
        if (!StoreValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        try {
            storeService.get(id);
            writeString("Your finding address is: " + storeService.get(id));
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getAll() {
        Store[] stores = storeService.getAll();
        for (int i = 0; i < stores.length; i++) {
            writeString((i + 1) + " " + stores[i]);
        }

    }

    public void getByTitle() {
        writeString("Enter new title");
        String title = readString();
        if (!StoreValidator.validTitle(title)) {
            writeString("Invalid title: " + title);
            return;
        }
        try {
            storeService.get(title);
            writeString("Your finding address is: " + storeService.get(title));
        } catch (StorageException e) {
            System.err.println(e.getMessage());
        }
    }
}

