package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.RockGroupsDao;
import ru.exerciss.entity.RockGroups;
import ru.exerciss.service.RockGroupsService;

import java.util.List;

@Service("rockGroupsService")
public class RockGroupsServiceImpl implements RockGroupsService {
    @Autowired
    private RockGroupsDao rockGroupsDao;

    @Override
    public RockGroups addRockGroups(RockGroups rockGroups) {
        return rockGroupsDao.create(rockGroups);
    }

    @Override
    public List<RockGroups> getAllRockGroups() {
        return rockGroupsDao.getList();
    }

    @Override
    public RockGroups getRockGroupsById(long id) {
        return rockGroupsDao.getById(id);
    }

    @Override
    public RockGroups deleteRockGroups(long id) {
        return rockGroupsDao.delete(rockGroupsDao.getById(id));
    }

    @Override
    public RockGroups updRockGroups(RockGroups rockGroups) {
        return rockGroupsDao.update(rockGroups);
    }
}
