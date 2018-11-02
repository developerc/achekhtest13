package ru.exerciss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exerciss.dao.AlbumDao;
import ru.exerciss.dto.AlbumDTO;
import ru.exerciss.entity.Album;
import ru.exerciss.service.AlbumService;

import java.util.List;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private AlbumDTO albumDTO;
    @Override
    public Album addAlbum(Album album) {
        return albumDao.create(album);
    }

    @Override
    public List<AlbumDTO> getAllAlbum() {
        return albumDTO.getAlbumDTOList(albumDao.getList());
//        return albumDao.getList();
    }


    @Override
    public Album getAlbumById(long id) {
        return albumDao.getById(id);
    }

    @Override
    public Album deleteAlbum(long id) {
        return albumDao.delete(albumDao.getById(id));
    }

    @Override
    public Album updAlbum(Album album) {
        return albumDao.update(album);
    }
}
