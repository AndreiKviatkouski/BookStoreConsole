package com.company.service;

import com.company.domain.User;

public interface UserService {
    boolean save(User user);

    //    User updateUser(User user, int id);

    String updateUserByLogin(String login, int id);

    String updateUserByPassword(String password, int id);

    String updateUserByName(String name, int id);

    void remove(int id);

    void remove(User user);

    User getById(int id);

    User getByLogin(String login);

    User[] getAll();

}
