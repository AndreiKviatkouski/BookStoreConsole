package com.company.storage;

import com.company.domain.User;

public interface UserStorage {
    boolean save(User user);

//    User updateUser(User user, int id);
    String updateUserByLogin(String login, int id);
    String updateUserByPassword(String password, int id);
    String updateUserByName(String name, int id);

    void remove(int id);

    void remove(User user);

    User getById(int id);

    User getByLogin(String login);
    String getByName(String login);

    User[] getAll();

    boolean contains(User user);

    boolean contains(int id);

    boolean contains (String login);

    boolean checkUser (String login,String password);
}
