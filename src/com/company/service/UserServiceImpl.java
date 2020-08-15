package com.company.service;

import com.company.domain.User;
import com.company.service.exception.UserException;
import com.company.storage.UserStorage;
import com.company.storage.UserStorageImpl;

public class UserServiceImpl implements UserService {
    private UserStorage userStorage = new UserStorageImpl();

    @Override
    public boolean save(User user) {
        if (userStorage.contains(user)) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    // TODO: 12.08.2020 Создать UserNotFoundException и бросать его везде вместо null
    // TODO: 12.08.2020 Реализовать меню пользователя и меню админа
    @Override
    public String updateUserByLogin(String login, int id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.updateUserByLogin(login, id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public String updateUserByPassword(String password, int id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.updateUserByPassword(password, id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public String updateUserByName(String name, int id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.updateUserByName(name, id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public void remove(int id) {
        if (userStorage.contains(id)) {
            userStorage.remove(id);
        }

    }

    @Override
    public void remove(User user) {
        if (userStorage.contains(user)) {
            userStorage.remove(user);
        }
    }

    @Override
    public User getById(int id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public User getByLogin(String login) {
        if (userStorage.contains(login)) {
            return userStorage.getByLogin(login);
        }
        return null;
    }


    @Override
    public User checkUser(String login, String password) {
        if (userStorage.contains(login, password)) {
            return userStorage.getByLogin(login);
        }
        return null;
    }

    @Override
    public User[] getAll() {
        return userStorage.getAll();
    }
}
