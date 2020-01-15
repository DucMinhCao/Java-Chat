package DAO;

import Model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAO {

    public void saveUser(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Hibernate Exception " + e.getStackTrace());
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User getUserByUsername(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            User user = null;
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", name));
            List<User> resultList = criteria.list();
            if (resultList.size() > 0) {
                user = (User) criteria.list().get(0);
            }
            session.getTransaction().commit();
            return user;
        } catch (HibernateException e) {
            System.out.println("Hibernate Excetpion: " + e.getStackTrace());
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
