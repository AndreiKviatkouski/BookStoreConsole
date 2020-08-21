package com.company.storage;

import com.company.domain.Address;
import com.company.domain.Author;

import java.util.Arrays;

public class AddressStorageImpl implements AddressStorage {
    private static Address[] addresses = new Address[50];
    static {
        addresses[0]=new Address("Nezavisimosti", 10);
    }

    @Override
    public boolean save(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) {
                addresses[i] = address;
                return true;
            }

        }
        return false;
    }

    @Override
    public int updateHomeById(int home, int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                int home1 = addresses[i].getHome();
                addresses[i].setHome(home);
                return home1;
            }

        }
        return -1;
    }

    @Override
    public String updateStreetById(String street, int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                String street1 = addresses[i].getStreet();
                addresses[i].setStreet(street);
                return street1;

            }

        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                for (int j = i; j < addresses.length + 1; j++) {
                    addresses[i] = addresses[j + 1];
                }
            }

        }
    }

    @Override
    public void remove(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].equals(address)) {
                for (int j = i; j < addresses.length + 1; j++) {
                    addresses[i] = addresses[j + 1];
                }
            }
        }
    }

    @Override
    public Address getById(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                return addresses[i];
            }

        }
        return null;
    }

    @Override
    public Address[] getAll() {
        int count = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] != null) {
                count++;
            }
        }

        return Arrays.copyOf(addresses, count);
    }

    @Override
    public Address[] getAllByHome(int home) {
        int count = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getHome() == home) {
                count++;
            }
        }
        return Arrays.copyOf(addresses, count);
    }

    @Override
    public Address[] getAllByStreet(String street) {
        int count = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getStreet() == street) {
                count++;
            }
        }
        return Arrays.copyOf(addresses, count);
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == address) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String street) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getStreet().equals(street)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int home, int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getHome() == home && addresses[i].getId()==id) {
                return true;

            }

        }
        return false;
    }
}
