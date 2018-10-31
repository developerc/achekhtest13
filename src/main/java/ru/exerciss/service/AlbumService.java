package ru.exerciss.service;

import ru.exerciss.dto.AlbumDTO;
import ru.exerciss.entity.Album;

import java.util.List;

public interface AlbumService {
    /**
     * method for add Album to base
     *
     * @param album = new Album for creation in DB
     * @return created Album
     */
    Album addAlbum(Album album);

    /**
     * method for receiving all Album
     *
     * @return all Album
     */
    List<AlbumDTO> getAllAlbum();

    /**
     * method for receive specify Album by id
     *
     * @param id = uniq Album id
     * @return specify Album by id
     */
    Album getAlbumById(long id);

    /**
     * method for Album delete
     *
     * @param id = Album's id for delete
     * @return removed Album
     */
    Album deleteAlbum(long id);

    /**
     * method for update Album
     *
     * @param album = update existing Album in DB
     * @return updated Album
     */
    Album updAlbum(Album album);
}
