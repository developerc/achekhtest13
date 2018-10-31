package ru.exerciss.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String album;
    //один альбом содержит несколько песен
    //и в разных альбомах может быть одинаковая песня
    @ManyToMany(mappedBy = "albumList",fetch = FetchType.EAGER)
    private List<SongPlayers> songPlayersList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<SongPlayers> getSongPlayersList() {
        return songPlayersList;
    }

    public void setSongPlayersList(List<SongPlayers> songPlayersList) {
        this.songPlayersList = songPlayersList;
    }
}
