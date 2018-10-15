package ru.exerciss.dao.impl;

import ru.exerciss.dao.PeopleDao;
import ru.exerciss.entity.People;

public class PeopleDaoImpl  extends BasicDaoImpl<People> implements PeopleDao {
    public PeopleDaoImpl(Class<People> entityClass) {
        super(entityClass);
    }

}
