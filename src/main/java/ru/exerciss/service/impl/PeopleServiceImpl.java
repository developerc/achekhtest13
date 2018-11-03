package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.PeopleDao;
import ru.exerciss.dto.PeopleDTO;
import ru.exerciss.entity.People;
import ru.exerciss.service.PeopleService;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;
    @Autowired
    private PeopleDTO peopleDTO;

    @Override
    public People addPeople(People people) {
        return peopleDao.create(people);
    }

    @Override
    public List<PeopleDTO> getAllPeople() {
        return peopleDTO.getPeopleDTOList(peopleDao.getList());
    }

    @Override
    public PeopleDTO getPeopleById(long id) {
        return peopleDTO.getPeopleDTObyId(peopleDao.getById(id));
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
