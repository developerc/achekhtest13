package ru.exerciss.dao;

import ru.exerciss.entity.People;

import java.util.List;

public interface PeopleDao extends BasicDao<People> {
    /**
     * method for finding List People by human
     *@param human = human of People
     *@return List People  with success parameters
     * **/
    List<People> getPeopleByHuman(String human);
}
