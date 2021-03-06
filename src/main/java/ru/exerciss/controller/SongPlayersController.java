package ru.exerciss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.exerciss.dto.SongPlayersDTO;
import ru.exerciss.entity.SongPlayers;
import ru.exerciss.service.SongPlayersService;

import java.util.List;

@Controller
@RequestMapping("/songplayers")
public class SongPlayersController {
    @Autowired
    private SongPlayersService songPlayersService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public SongPlayers addSongPlayers(@RequestBody SongPlayers songPlayers){
        return songPlayersService.addSongPlayers(songPlayers);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SongPlayersDTO> getSongPlayers(){
        return songPlayersService.getAllSongPlayers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public SongPlayersDTO getSongPlayersById(@PathVariable(value = "id") String id){
        // exception
        return songPlayersService.getSongPlayersById(Long.parseLong(id));
    }

    @RequestMapping(value = "/getbysong/{song}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SongPlayersDTO> getSongPlayersBySong(@PathVariable(value = "song") String song){
        return songPlayersService.getSongPlayersBySong(song);
    }

    @RequestMapping(value = "/getbyalbum/{album}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SongPlayersDTO> getSongPlayersByAlbum(@PathVariable(value = "album") String album){
        return songPlayersService.getSongPlayersByAlbum(album);
    }

    @RequestMapping(value = "/getbycomposer/{composer}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SongPlayersDTO> getSongPlayersByComposer(@PathVariable(value = "composer") String composer){
        return songPlayersService.getSongPlayersByComposer(composer);
    }

    @RequestMapping(value = "/getbypoet/{poet}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SongPlayersDTO> getSongPlayersByPoet(@PathVariable(value = "poet") String poet){
        return songPlayersService.getSongPlayersByPoet(poet);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public SongPlayers deleteSongPlayers(@RequestParam(value = "id") String id) {
        return songPlayersService.deleteSongPlayers(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public SongPlayers updSongPlayers(@RequestBody SongPlayers songPlayers){
        return songPlayersService.updSongPlayers(songPlayers);
    }
}
