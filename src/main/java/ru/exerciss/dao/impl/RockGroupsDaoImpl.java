package ru.exerciss.dao.impl;

import ru.exerciss.dao.RockGroupsDao;
import ru.exerciss.entity.RockGroups;

public class RockGroupsDaoImpl extends BasicDaoImpl<RockGroups> implements RockGroupsDao {
    public RockGroupsDaoImpl(Class<RockGroups> entityClass) {
        super(entityClass);
    }

}
