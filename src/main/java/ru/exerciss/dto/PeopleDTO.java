package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.People;
import ru.exerciss.entity.RockGroups;
import ru.exerciss.entity.SongPlayers;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDTO {
    private long id;
    private String human;
    private RockGroups rockGroups;
    private List<SongPlayers> songPlayersList;

    public List<PeopleDTO> getPeopleDTOList(List<People> peopleList){
        List<PeopleDTO> peopleDTOList = new ArrayList<>();

        for (People people : peopleList){
            PeopleDTO peopleDTO = new PeopleDTO();
            peopleDTO.setId(people.getId());
            peopleDTO.setHuman(people.getHuman());
            peopleDTO.setRockGroups(people.getRockGroups());
//            peopleDTO.setRockGroups(people.getRockGroups().getRockGroup());
//            List<SongPlayers> songPlayersList = new ArrayList<>();
            /*for (SongPlayers songPlayers : people.getSongComposer()){
                songPlayersList.add(songPlayers);
            }
            peopleDTO.setSongPlayersList(songPlayersList);*/
           /*songPlayersList = people.getSongComposer();
           peopleDTO.setSongPlayersList(songPlayersList);*/
//           peopleDTO.setSongPlayersList(people.getSongComposer());

            peopleDTOList.add(peopleDTO);
        }

        return peopleDTOList;
    }

    public List<SongPlayers> getSongPlayersList() {
        return songPlayersList;
    }

    public void setSongPlayersList(List<SongPlayers> songPlayersList) {
        this.songPlayersList = songPlayersList;
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
