package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import user.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public User getUserById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
