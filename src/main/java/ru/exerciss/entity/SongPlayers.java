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

    //у композиции один композитор
    private String composer;

    // и один автор стихов
    private String poet;

    //и много исполнителей
    //исполнители могут исполнять разные песни
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<People> songInstrumentalist;

    //песня может содержаться в разных альбомах
    //и альбом содержит разные песни
    /*@ManyToMany(mappedBy = "songPlayersList")
    private List<Album> albumList;
*/


    /*@OneToOne
    private People composer;*/
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
    /*@ManyToOne
    private People composer;*/


    //список исполнителей
    /*@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<People> peopleList = new ArrayList<>();*/


    /*public People getComposer() {
        return composer;
    }

    public void setComposer(People composer) {
        this.composer = composer;
    }*/

   /* public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }*/

    /*public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }*/

    public List<People> getSongInstrumentalist() {
        return songInstrumentalist;
    }

    public void setSongInstrumentalist(List<People> songInstrumentalist) {
        this.songInstrumentalist = songInstrumentalist;
    }

    public String getPoet() {
        return poet;
    }

    public void setPoet(String poet) {
        this.poet = poet;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
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
