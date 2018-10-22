package ru.exerciss.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SongPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String song;

    /*@OneToMany
    private List<People> peopleList;*/
    /*@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<RockGroups> rockGroupsList = new ArrayList<>();*/
    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rockGroups_id")
    private RockGroups rockGroups;

    public RockGroups getRockGroups() {
        return rockGroups;
    }

    public void setRockGroups(RockGroups rockGroups) {
        this.rockGroups = rockGroups;
    }*/

    //композитор
    @ManyToOne
    private People composer;


    //список исполнителей
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<People> peopleList = new ArrayList<>();


    public People getComposer() {
        return composer;
    }

    public void setComposer(People composer) {
        this.composer = composer;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

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


}
