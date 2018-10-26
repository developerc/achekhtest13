package ru.exerciss.dto;

import org.springframework.stereotype.Component;

@Component
public class SongPlayersDTO {
    private long id;
    private String song;
    private String composer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}
