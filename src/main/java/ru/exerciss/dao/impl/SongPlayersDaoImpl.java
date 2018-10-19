package ru.exerciss.dao.impl;

import ru.exerciss.dao.SongPlayersDao;
import ru.exerciss.entity.SongPlayers;

public class SongPlayersDaoImpl extends BasicDaoImpl<SongPlayers> implements SongPlayersDao {
    public SongPlayersDaoImpl(Class<SongPlayers> entityClass) {
        super(entityClass);
    }
}
