package Preprojoct.stringboot.dao;


import Preprojoct.stringboot.model.User;

import java.util.List;


public interface UserDao {

    void add(User user);

    void update(User user);

    void delete(Long id);

    List<User> getAllUsers();

}

