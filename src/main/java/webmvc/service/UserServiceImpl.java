package webmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webmvc.dao.UserDao;
import webmvc.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
       User nowUser =  userDao.findById(user.getId());
       nowUser.setName(user.getName());
       nowUser.setEmail(user.getEmail());
       userDao.save(nowUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
