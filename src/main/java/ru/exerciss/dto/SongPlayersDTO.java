package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.People;
import ru.exerciss.entity.SongPlayers;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongPlayersDTO {
    private long id;
    private String song;
    private String composer;
    private String poet;
    private List<PeopleDTO> songInstrumentalistList;

    public List<SongPlayersDTO> getSongPlayersDTOList(List<SongPlayers> songPlayersList){
        List<SongPlayersDTO> songPlayersDTOList = new ArrayList<>();

        for (SongPlayers songPlayers : songPlayersList){
            songInstrumentalistList = new ArrayList<>();

            SongPlayersDTO songPlayersDTO = new SongPlayersDTO();
            songPlayersDTO.setId(songPlayers.getId());
            songPlayersDTO.setSong(songPlayers.getSong());
            songPlayersDTO.setComposer(songPlayers.getComposer());
            for (People people : songPlayers.getSongInstrumentalist()){
                PeopleDTO peopleDTO = new PeopleDTO();
                peopleDTO.setId(people.getId());
                peopleDTO.setHuman(people.getHuman());
                songInstrumentalistList.add(peopleDTO);
            }

            songPlayersDTO.setSongInstrumentalistList(songInstrumentalistList);
            songPlayersDTOList.add(songPlayersDTO);
        }

        return songPlayersDTOList;
    }

    public List<PeopleDTO> getSongInstrumentalistList() {
        return songInstrumentalistList;
    }

    public void setSongInstrumentalistList(List<PeopleDTO> songInstrumentalistList) {
        this.songInstrumentalistList = songInstrumentalistList;
    }

    public String getPoet() {
        return poet;
    }

    public void setPoet(String poet) {
        this.poet = poet;
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
