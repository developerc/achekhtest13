package ru.exerciss.dao.impl;

import ru.exerciss.dao.SongPlayersDao;
import ru.exerciss.entity.SongPlayers;

import javax.persistence.Query;
import java.util.List;

public class SongPlayersDaoImpl extends BasicDaoImpl<SongPlayers> implements SongPlayersDao {
    public SongPlayersDaoImpl(Class<SongPlayers> entityClass) {
        super(entityClass);
    }

    @Override
    public List<SongPlayers> getSongPlayersBySong(String song) {
        Query query = getSessionFactory().createQuery("SELECT a FROM SongPlayers as a WHERE (a.song = :Song )");
        query.setParameter("Song", song);
        return query.getResultList();
    }

    @Override
    public List<SongPlayers> getSongPlayersByAlbum(String album) {
        Query query = getSessionFactory().createQuery("SELECT a FROM SongPlayers as a WHERE (a.album = :Album )");
        query.setParameter("Album", album);
        return query.getResultList();
    }

    @Override
    public List<SongPlayers> getSongPlayersByComposer(String composer) {
        Query query = getSessionFactory().createQuery("SELECT a FROM SongPlayers as a WHERE (a.composer = :Composer )");
        query.setParameter("Composer", composer);
        return query.getResultList();
    }

    @Override
    public List<SongPlayers> getSongPlayersByPoet(String poet) {
        Query query = getSessionFactory().createQuery("SELECT a FROM SongPlayers as a WHERE (a.poet = :Poet )");
        query.setParameter("Poet", poet);
        return query.getResultList();
    }
}
