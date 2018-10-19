package ru.exerciss.service;

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
    List<SongPlayers> getAllSongPlayers();

    /**
     * method for receive specify SongPlayers by id
     *
     * @param id = uniq SongPlayers id
     * @return specify SongPlayers by id
     */
    SongPlayers getSongPlayersById(long id);

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
}