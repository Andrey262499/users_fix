package webmvc.service;

import webmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(int id);

}
