package com.company.service;

import com.company.domain.User;
import com.company.service.exception.ServiceException;

public interface UserService {
    boolean save(User user);


    String updateUserByLogin(String login, int id) throws ServiceException;

    String updateUserByPassword(String password, int id) throws ServiceException;

    String updateUserByName(String name, int id) throws ServiceException;

    void remove(int id);

    void remove(User user);

    User getById(int id) throws ServiceException;

    User getByLogin(String login);

    User checkUser(String login,String password);

    User[] getAll();

}
