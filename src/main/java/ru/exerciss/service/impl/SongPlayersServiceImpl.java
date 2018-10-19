package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.SongPlayersDao;
import ru.exerciss.entity.SongPlayers;
import ru.exerciss.service.SongPlayersService;

import java.util.List;

@Service("songPlayersService")
public class SongPlayersServiceImpl implements SongPlayersService {
    @Autowired
    private SongPlayersDao songPlayersDao;

    @Override
    public SongPlayers addSongPlayers(SongPlayers songPlayers) {
        return songPlayersDao.create(songPlayers);
    }

    @Override
    public List<SongPlayers> getAllSongPlayers() {
        return songPlayersDao.getList();
    }

    @Override
    public SongPlayers getSongPlayersById(long id) {
        return songPlayersDao.getById(id);
    }

    @Override
    public SongPlayers deleteSongPlayers(long id) {
        return songPlayersDao.delete(songPlayersDao.getById(id));
    }

    @Override
    public SongPlayers updSongPlayers(SongPlayers songPlayers) {
        return songPlayersDao.update(songPlayers);
    }
}
