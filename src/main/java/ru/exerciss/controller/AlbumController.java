package ru.exerciss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.exerciss.dto.AlbumDTO;
import ru.exerciss.entity.Album;
import ru.exerciss.service.AlbumService;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Album addAlbum(@RequestBody Album album){
        return albumService.addAlbum(album);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<AlbumDTO> getAlbum(){
        return albumService.getAllAlbum();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Album getAlbumById(@PathVariable(value = "id") String id){
        // exception
        return albumService.getAlbumById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Album deleteAlbum(@RequestParam(value = "id") String id) {
        return albumService.deleteAlbum(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Album updAlbum(@RequestBody Album album){
        return albumService.updAlbum(album);
    }
}
