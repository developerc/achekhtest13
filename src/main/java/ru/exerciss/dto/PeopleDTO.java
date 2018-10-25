package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.People;
import ru.exerciss.entity.RockGroups;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDTO {
    private long id;
    private String human;

    private RockGroups rockGroups;

    public List<PeopleDTO> getPeopleDTOList(List<People> peopleList){
        List<PeopleDTO> peopleDTOList = new ArrayList<>();

        for (People people : peopleList){
            PeopleDTO peopleDTO = new PeopleDTO();
            peopleDTO.setId(people.getId());
            peopleDTO.setHuman(people.getHuman());
            peopleDTO.setRockGroups(people.getRockGroups());
//            peopleDTO.setRockGroups(people.getRockGroups().getRockGroup());

            peopleDTOList.add(peopleDTO);
        }

        return peopleDTOList;
    }

    public RockGroups getRockGroups() {
        return rockGroups;
    }

    public void setRockGroups(RockGroups rockGroups) {
        this.rockGroups = rockGroups;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }
}
