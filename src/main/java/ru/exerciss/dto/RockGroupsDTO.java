package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.People;
import ru.exerciss.entity.RockGroups;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockGroupsDTO {
    private long id;
    private String rockGroup;
    private List<PeopleDTO> peopleDTOList = new ArrayList<>();

    public List<RockGroupsDTO> getRockGroupsDTOList(List<RockGroups> rockGroupsList){
        List<RockGroupsDTO> rockGroupsDTOList = new ArrayList<>();

        for (RockGroups rockGroups : rockGroupsList){
            List<PeopleDTO> peopleDTOList = new ArrayList<>();

            RockGroupsDTO rockGroupsDTO = new RockGroupsDTO();
            rockGroupsDTO.setId(rockGroups.getId());
            rockGroupsDTO.setRockGroup(rockGroups.getRockGroup());

            for (People people : rockGroups.getGroupParticipant()){
                PeopleDTO peopleDTO = new PeopleDTO();
                peopleDTO.setId(people.getId());
                peopleDTO.setHuman(people.getHuman());

                peopleDTOList.add(peopleDTO);
            }

            rockGroupsDTO.setPeopleDTOList(peopleDTOList);
            rockGroupsDTOList.add(rockGroupsDTO);
        }

        return rockGroupsDTOList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRockGroup() {
        return rockGroup;
    }

    public void setRockGroup(String rockGroup) {
        this.rockGroup = rockGroup;
    }

    public List<PeopleDTO> getPeopleDTOList() {
        return peopleDTOList;
    }

    public void setPeopleDTOList(List<PeopleDTO> peopleDTOList) {
        this.peopleDTOList = peopleDTOList;
    }
}
