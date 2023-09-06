package ru.ruba.Cinema_Project.dao.impl;

import ru.ruba.Cinema_Project.dao.AbstractDao;
import ru.ruba.Cinema_Project.dao.TicketDao;
import ru.ruba.Cinema_Project.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
