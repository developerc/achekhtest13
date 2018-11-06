package ru.exerciss.dao.impl;

import ru.exerciss.dao.PeopleDao;
import ru.exerciss.entity.People;

import javax.persistence.Query;
import java.util.List;

public class PeopleDaoImpl  extends BasicDaoImpl<People> implements PeopleDao {
    public PeopleDaoImpl(Class<People> entityClass) {
        super(entityClass);
    }

    @Override
    public List<People> getPeopleByHuman(String human) {
        Query query = getSessionFactory().createQuery("SELECT a FROM People as a WHERE (a.human = :Human )");
        query.setParameter("Human", human);
        return query.getResultList();
    }
}
