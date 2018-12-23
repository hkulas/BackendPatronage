package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConferenceRooms")
public class ConferenceRoomController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @RequestMapping("/{id}")
    public ConferenceRoom get(@PathVariable Long id){
        return conferenceRoomService.get(id);

    }
    @RequestMapping()
    public List<ConferenceRoom> getAll(){
        return conferenceRoomService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody ConferenceRoom conferenceRoom){
        conferenceRoomService.add(conferenceRoom);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public void update(@RequestBody ConferenceRoom conferenceRoom, @PathVariable Long id){
        conferenceRoomService.update(id,conferenceRoom);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomService.delete(id);
    }
}
