package ru.exerciss.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RockGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rockGroup;

    @OneToMany(mappedBy = "rockGroups", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<People> groupParticipant = new ArrayList<>();

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

    public List<People> getGroupParticipant() {
        return groupParticipant;
    }

    public void setGroupParticipant(List<People> groupParticipant) {
        this.groupParticipant = groupParticipant;
    }
}
