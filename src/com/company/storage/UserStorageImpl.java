package com.company.storage;

import com.company.console.util.Writer;
import com.company.domain.Role;
import com.company.domain.User;

import java.util.Arrays;

import static com.company.domain.Role.ADMIN;
import static com.company.domain.Role.USER;

public class UserStorageImpl implements UserStorage {
    private static User[] users = new User[50];

    static {
        users[0] = new User(1, "admin", "admin", "Admin", ADMIN);
        users[1] = new User(2, "user", "user", "User", USER);
    }

    @Override
    public boolean save(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public String updateUserByLogin(String login, int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                return users[i].getLogin();
            }

        }
        return null;
    }

    @Override
    public String updateUserByPassword(String password, int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                return users[i].getPassword();
            }
        }

        return null;
    }

    @Override
    public String updateUserByName(String name, int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                return users[i].getName();
            }

        }
        return null;
    }

//    @Override
//    public User updateUser(User user, int id) {
//        for (int i = 0; i < users.length; i++) {
//            if (users[i] == null) {
//                Writer.writeString("Users list is empty");
//            }
//            if (users[i].getId() == id) {
//                users[i] = user;
//                return user;
//            }
//        }
//        return null;
//    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                for (int j = i; j < users.length + 1; j++) {
                    users[i] = users[j + 1];

                }
                break;
            }

        }

    }

    @Override
    public void remove(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                for (int j = i; j < users.length + 1; j++) {
                    users[i] = users[j + 1];
                }
                break;
            }

        }

    }

    @Override
    public User getById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }

        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getLogin().equals(login)) {
                return users[i];

            }

        }
        return null;
    }

    @Override
    public String getByName(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getLogin().equals(login)) {
                return users[i].getName();

            }
        }
        return null;
    }

    @Override
    public User[] getAll() {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                count++;
            }
        }
//        Writer.writeObject(Arrays.toString(Arrays.copyOf(users, count)));
//        User[]userNew = new User[count];
//        for (int i = 0; i < userNew.length; i++) {
//            userNew[i]=users[i];
//            Writer.writeObject(userNew[i]);
//        }
        return Arrays.copyOf(users, count);
    }

    @Override
    public boolean contains(User user) {
        for (User value : users) {
            if (value == null) break;
            if (value.equals(user)) {
                return true;
            }


        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getLogin().equals(login)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String login, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getLogin().equals(login) && users[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
