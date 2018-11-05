package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.SongPlayersDao;
import ru.exerciss.dto.SongPlayersDTO;
import ru.exerciss.entity.SongPlayers;
import ru.exerciss.service.SongPlayersService;

import java.util.List;

@Service("songPlayersService")
public class SongPlayersServiceImpl implements SongPlayersService {
    @Autowired
    private SongPlayersDao songPlayersDao;
    @Autowired
    private SongPlayersDTO songPlayersDTO;

    @Override
    public SongPlayers addSongPlayers(SongPlayers songPlayers) {
        return songPlayersDao.create(songPlayers);
    }

    @Override
    public List<SongPlayersDTO> getAllSongPlayers() {
        return songPlayersDTO.getSongPlayersDTOList(songPlayersDao.getList());
    }

    @Override
    public SongPlayersDTO getSongPlayersById(long id) {
        return songPlayersDTO.getSongPlayersDTObyId(songPlayersDao.getById(id));
    }

    @Override
    public SongPlayers deleteSongPlayers(long id) {
        return songPlayersDao.delete(songPlayersDao.getById(id));
    }

    @Override
    public SongPlayers updSongPlayers(SongPlayers songPlayers) {
        return songPlayersDao.update(songPlayers);
    }

    @Override
    public List<SongPlayersDTO> getSongPlayersBySong(String song) {
        return songPlayersDTO.getSongPlayersDTOList(songPlayersDao.getSongPlayersBySong(song));
    }
}
