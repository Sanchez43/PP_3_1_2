package Preprojoct.stringboot.service;



import Preprojoct.stringboot.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void update(User user);

    void delete(Long id);

    List<User> getAllUsers();

}
