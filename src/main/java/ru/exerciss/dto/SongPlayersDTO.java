package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.SongPlayers;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongPlayersDTO {
    private long id;
    private String song;
    private String composer;

    public List<SongPlayersDTO> getSongPlayersDTOList(List<SongPlayers> songPlayersList){
        List<SongPlayersDTO> songPlayersDTOList = new ArrayList<>();

        return songPlayersDTOList;
    }

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
