package ru.exerciss.service;

import ru.exerciss.dto.SongPlayersDTO;
import ru.exerciss.entity.SongPlayers;

import java.util.List;

public interface SongPlayersService {
    /**
     * method for add SongPlayers to base
     *
     * @param songPlayers = new SongPlayers for creation in DB
     * @return created SongPlayers
     */
    SongPlayers addSongPlayers(SongPlayers songPlayers);

    /**
     * method for receiving all SongPlayers
     *
     * @return all SongPlayers
     */
    List<SongPlayersDTO> getAllSongPlayers();

    /**
     * method for receive specify SongPlayers by id
     *
     * @param id = uniq SongPlayers id
     * @return specify SongPlayers by id
     */
    SongPlayersDTO getSongPlayersById(long id);

    /**
     * method for SongPlayers delete
     *
     * @param id = SongPlayers's id for delete
     * @return removed SongPlayers
     */
    SongPlayers deleteSongPlayers(long id);

    /**
     * method for update SongPlayers
     *
     * @param songPlayers = update existing SongPlayers in DB
     * @return updated SongPlayers
     */
    SongPlayers updSongPlayers(SongPlayers songPlayers);

    /**
     * method for receiving all SongPlayers by song
     *
     * @return all SongPlayers by song
     */
    List<SongPlayersDTO> getSongPlayersBySong(String song);

    /**
     * method for receiving all SongPlayers by album
     *
     * @return all SongPlayers by album
     */
    List<SongPlayersDTO> getSongPlayersByAlbum(String album);

    /**
     * method for receiving all SongPlayers by composer
     *
     * @return all SongPlayers by composer
     */
    List<SongPlayersDTO> getSongPlayersByComposer(String composer);

    /**
     * method for receiving all SongPlayers by poet
     *
     * @return all SongPlayers by poet
     */
    List<SongPlayersDTO> getSongPlayersByPoet(String poet);
}
