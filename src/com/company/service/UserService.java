package com.company.service;

import com.company.domain.User;
import com.company.service.exception.UserException;

public interface UserService {
    boolean save(User user);


    String updateUserByLogin(String login, int id) throws UserException;

    String updateUserByPassword(String password, int id) throws UserException;

    String updateUserByName(String name, int id) throws UserException;

    void remove(int id);

    void remove(User user);

    User getById(int id) throws UserException;

    User getByLogin(String login);

    User checkUser(String login,String password);

    User[] getAll();

}
