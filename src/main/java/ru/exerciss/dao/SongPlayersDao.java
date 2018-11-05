package ru.exerciss.dao;

import ru.exerciss.entity.SongPlayers;

import java.util.List;

public interface SongPlayersDao extends BasicDao<SongPlayers> {
    /**
     * method for finding List SongPlayers by song
     *@param song = song of SongPlayers
     *@return List SongPlayers  with success parameters
     * **/
    List<SongPlayers> getSongPlayersBySong(String song);
}
