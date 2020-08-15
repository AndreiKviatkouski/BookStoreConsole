package com.company.console.action;

import com.company.console.validator.AddressValidator;
import com.company.domain.Address;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class AddressAction {
    private AddressService addressService = new AddressServiceImpl();

    public void add() {
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
        addressService.save(address);
        writeString("Address was add: " + address);
    }

    public void updateHomeById() {
        writeString("Enter id");
        int id = readInt();
        if (!AddressValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter home number");
        int home = readInt();
        if (!AddressValidator.validHome(home)) {
            writeString("Invalid number home: " + home);
            return;
        }
        addressService.updateHomeById(id, home);
        writeString("Home number was updated:" + home);

    }

    public void updateStreetById() {
        writeString("Enter id");
        int id = readInt();
        if (!AddressValidator.validId(id)) {
            writeString("Invalid id: " + id);
            return;
        }
        writeString("Enter street");
        String street = readString();
        if (!AddressValidator.validStreet(street)) {
            writeString("Invalid street:" + street);
            return;
        }
        addressService.updateStreetById(street, id);
        writeString("Street was added: " + street);
    }

    public void removeByID() {
        writeString("Enter id");
        int id = readInt();
        if (!AddressValidator.validId(id)) {
            writeString("Invalid id: " + id);
            return;
        }
        addressService.remove(id);
        writeString("Address was deleted: " + addressService.getById(id));
    }

    public void remove() {
        Address[] all = addressService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getStreet() + "-" + all[i].getHome());
        }
        int i = readInt() - 1;
        Address address = all[i];
        addressService.remove(address);
        writeString("Address was deleted: " + address);

    }

    public void getById() {
        writeString("Enter id");
        int id = readInt();
        if (!AddressValidator.validId(id)) {
            writeString("Invalid id: " + id);
            return;
        }
        addressService.getById(id);
        writeString("Your finding address is: " + addressService.getById(id));

    }

    public void getAll() {
        Address[] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            writeString((i + 1) + " " + addresses[i]);
        }

    }

    public void getALLByHome() {
        writeString("Enter home number");
        int home = readInt();
        if (!AddressValidator.validHome(home)) {
            writeString("Invalid number home: " + home);
            return;
        }
        Address[] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getHome() == home) {
                writeString((i + 1) + " " + addresses[i].getHome());
            }
        }

    }

    public void getALLByStreet() {
        writeString("Enter street");
        String street = readString();
        if (!AddressValidator.validStreet(street)) {
            writeString("Invalid number home: " + street);
            return;
        }
        Address[] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getStreet().equals(street)) {
                writeString((i + 1) + " " + addresses[i].getStreet());
            }
        }

    }

}



