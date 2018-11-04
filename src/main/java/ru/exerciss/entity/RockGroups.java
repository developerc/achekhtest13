package ru.exerciss.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RockGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rockGroup;

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
}
