package ru.ruba.Cinema_Project.dao.impl;

import ru.ruba.Cinema_Project.dao.AbstractDao;
import ru.ruba.Cinema_Project.dao.CinemaHallDao;
import ru.ruba.Cinema_Project.model.CinemaHall;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}