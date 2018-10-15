package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.PeopleDao;
import ru.exerciss.entity.People;
import ru.exerciss.service.PeopleService;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    public People addPeople(People people) {
        return peopleDao.create(people);
    }

    @Override
    public List<People> getAllPeople() {
        return peopleDao.getList();
    }

    @Override
    public People getPeopleById(long id) {
        return peopleDao.getById(id);
    }

    @Override
    public People deletePeople(long id) {
        return peopleDao.delete(peopleDao.getById(id));
    }

    @Override
    public People updPeople(People people) {
        return peopleDao.update(people);
    }
}
