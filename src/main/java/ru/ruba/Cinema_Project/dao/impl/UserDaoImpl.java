package ru.ruba.Cinema_Project.dao.impl;

import ru.ruba.Cinema_Project.dao.AbstractDao;
import ru.ruba.Cinema_Project.dao.UserDao;
import ru.ruba.Cinema_Project.exception.DataProcessingException;
import ru.ruba.Cinema_Project.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory factory) {
        super(factory, User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = factory.openSession()) {
            Query<User> findByEmail = session.createQuery("FROM User u "
                    + "JOIN FETCH u.roles WHERE u.email = :email", User.class);
            findByEmail.setParameter("email", email);
            return findByEmail.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("User with email " + email + " not found", e);
        }
    }
}