package ru.exerciss.service;

import ru.exerciss.dto.PeopleDTO;
import ru.exerciss.entity.People;

import java.util.List;

public interface PeopleService {
    /**
     * method for add People to base
     *
     * @param people = new People for creation in DB
     * @return created People
     */
    People addPeople(People people);

    /**
     * method for receiving all People
     *
     * @return all People
     */
    List<PeopleDTO> getAllPeople();

    /**
     * method for receive specify People by id
     *
     * @param id = uniq People id
     * @return specify People by id
     */
    PeopleDTO getPeopleById(long id);

    /**
     * method for People delete
     *
     * @param id = People's id for delete
     * @return removed People
     */
    People deletePeople(long id);

    /**
     * method for update People
     *
     * @param people = update existing People in DB
     * @return updated People
     */
    People updPeople(People people);
}

