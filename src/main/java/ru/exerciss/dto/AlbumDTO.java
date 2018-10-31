package ru.exerciss.dto;

import org.springframework.stereotype.Component;
import ru.exerciss.entity.Album;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumDTO {
    private long id;
    private String album;
    private List<SongPlayersDTO> songPlayersList;

    public List<AlbumDTO> getAlbumDTOList(List<Album> albumList){
        List<AlbumDTO> albumDTOList = new ArrayList<>();

        return albumDTOList;
    }

    public List<SongPlayersDTO> getSongPlayersList() {
        return songPlayersList;
    }

    public void setSongPlayersList(List<SongPlayersDTO> songPlayersList) {
        this.songPlayersList = songPlayersList;
    }

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
}
