package webmvc.dao;

import webmvc.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
    void delete(int id);
    User findById(int id);
}
