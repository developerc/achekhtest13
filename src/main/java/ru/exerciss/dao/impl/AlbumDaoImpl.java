package ru.exerciss.dao.impl;

import ru.exerciss.dao.AlbumDao;
import ru.exerciss.entity.Album;

public class AlbumDaoImpl extends BasicDaoImpl<Album> implements AlbumDao {
    public AlbumDaoImpl(Class<Album> entityClass) {
        super(entityClass);
    }
}

