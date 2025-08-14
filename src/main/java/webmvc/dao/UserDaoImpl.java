package webmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webmvc.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   @Transactional
    @Override
    public List<User> findAll() {
       return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
       sessionFactory.getCurrentSession().merge(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
       User user = sessionFactory.getCurrentSession().get(User.class, id);
       if(user != null){
           sessionFactory.getCurrentSession().delete(user);
       }
    }

    @Transactional
    @Override
    public User findById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
