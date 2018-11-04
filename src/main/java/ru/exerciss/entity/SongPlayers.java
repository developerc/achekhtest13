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

    //песня содержится в альбоме
    private String album;

    //и много исполнителей
    //исполнители могут исполнять разные песни
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<People> songInstrumentalist;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

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
