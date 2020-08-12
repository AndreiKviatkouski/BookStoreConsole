package com.company.service;

import com.company.domain.User;
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
    // TODO: 12.08.2020 Реализовать меню пользователя и меню админаЛ
    @Override
    public String updateUserByLogin(String login, int id) {
        if (userStorage.contains(id)){
            return userStorage.updateUserByLogin(login, id);
        }
        return null;
    }

    @Override
    public String updateUserByPassword(String password, int id) {
        if (userStorage.contains(id)){
            return userStorage.updateUserByPassword(password, id);
        }
        return null;
    }

    @Override
    public String updateUserByName(String name, int id) {
        if (userStorage.contains(id)){
            return updateUserByName(name, id);
        }
        return null;
    }

//    @Override
//    public User updateUser(User user, int id) {
//        if (userStorage.contains(id)) {
//            userStorage.updateUser(user, id);
//        }
//        return null;
//    }

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
    public User getById(int id) {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        if (userStorage.contains(login)) {
            userStorage.getByLogin(login);
        }
        return null;
    }

    @Override
    public User[] getAll() {
        return userStorage.getAll();
    }
}
