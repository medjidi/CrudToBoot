package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.UserDao;
import com.example.crudtoboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.creat(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional()
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }


}
