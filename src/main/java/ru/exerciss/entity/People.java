package ru.exerciss.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String human;

    /*private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }*/

   /* @OneToOne(mappedBy = "composer")
    private SongPlayers songComposer;*/
  /* @ManyToOne
   private SongPlayers songPlayers;*/

    @ManyToOne
    private RockGroups rockGroups;

    /*public SongPlayers getSongComposer() {
        return songComposer;
    }

    public void setSongComposer(SongPlayers songComposer) {
        this.songComposer = songComposer;
    }*/

    /*public SongPlayers getSongPlayers() {
        return songPlayers;
    }

    public void setSongPlayers(SongPlayers songPlayers) {
        this.songPlayers = songPlayers;
    }*/

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
