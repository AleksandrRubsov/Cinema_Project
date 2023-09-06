package ru.ruba.Cinema_Project.dao.impl;

import ru.ruba.Cinema_Project.dao.AbstractDao;
import ru.ruba.Cinema_Project.dao.RoleDao;
import ru.ruba.Cinema_Project.exception.DataProcessingException;
import ru.ruba.Cinema_Project.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> query = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            query.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get role: " + roleName, e);
        }
    }
}
