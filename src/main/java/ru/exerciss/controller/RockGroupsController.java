package ru.exerciss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.exerciss.dto.RockGroupsDTO;
import ru.exerciss.entity.RockGroups;
import ru.exerciss.service.RockGroupsService;

import java.util.List;

@Controller
@RequestMapping("/rockgroups")
public class RockGroupsController {
    @Autowired
    private RockGroupsService rockGroupsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RockGroups addRockGroups(@RequestBody RockGroups rockGroups){
        return rockGroupsService.addRockGroups(rockGroups);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<RockGroupsDTO> getRockGroups(){
        return rockGroupsService.getAllRockGroups();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RockGroups getPeopleById(@PathVariable(value = "id") String id){
        // exception
        return rockGroupsService.getRockGroupsById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RockGroups deleteRockGroups(@RequestParam(value = "id") String id) {
        return rockGroupsService.deleteRockGroups(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RockGroups updRockGroups(@RequestBody RockGroups rockGroups){
        return rockGroupsService.updRockGroups(rockGroups);
    }

}
