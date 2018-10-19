package ru.exerciss.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SongPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String song;

    @OneToMany
    private List<People> peopleList;
    @OneToMany
    private List<RockGroups> rockGroupsList;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    public List<RockGroups> getRockGroupsList() {
        return rockGroupsList;
    }

    public void setRockGroupsList(List<RockGroups> rockGroupsList) {
        this.rockGroupsList = rockGroupsList;
    }
}
