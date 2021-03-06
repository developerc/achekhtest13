package ru.exerciss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.exerciss.dto.PeopleDTO;
import ru.exerciss.entity.People;
import ru.exerciss.service.PeopleService;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public People addPeople(@RequestBody People people){
        return peopleService.addPeople(people);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<PeopleDTO> getPeople(){
        return peopleService.getAllPeople();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PeopleDTO getPeopleById(@PathVariable(value = "id") String id){
        // exception
        return peopleService.getPeopleById(Long.parseLong(id));
    }

    @RequestMapping(value = "/getbyhuman/{human}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<PeopleDTO> getPeopleByHuman(@PathVariable(value = "human") String human){
        return peopleService.getPeopleByHuman(human);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public People deletePeople(@RequestParam(value = "id") String id) {
        return peopleService.deletePeople(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public People updPeople(@RequestBody People people){
        return peopleService.updPeople(people);
    }
}
