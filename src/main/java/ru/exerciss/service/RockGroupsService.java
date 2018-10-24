package ru.exerciss.service;

import ru.exerciss.dto.RockGroupsDTO;
import ru.exerciss.entity.RockGroups;

import java.util.List;

public interface RockGroupsService {
    /**
     * method for add RockGroups to base
     *
     * @param rockGroups = new RockGroups for creation in DB
     * @return created RockGroups
     */
    RockGroups addRockGroups(RockGroups rockGroups);

    /**
     * method for receiving all RockGroups
     *
     * @return all RockGroups
     */
    List<RockGroupsDTO> getAllRockGroups();

    /**
     * method for receive specify RockGroups by id
     *
     * @param id = uniq RockGroups id
     * @return specify RockGroups by id
     */
    RockGroups getRockGroupsById(long id);

    /**
     * method for RockGroups delete
     *
     * @param id = RockGroups's id for delete
     * @return removed RockGroups
     */
    RockGroups deleteRockGroups(long id);

    /**
     * method for update People
     *
     * @param rockGroups = update existing RockGroups in DB
     * @return updated RockGroups
     */
    RockGroups updRockGroups(RockGroups rockGroups);
}
