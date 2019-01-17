package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomDto;
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
    public ConferenceRoomDto get(@PathVariable Long id){
        return conferenceRoomService.get(id);

    }
    @RequestMapping()
    public List<ConferenceRoomDto> getAll(){
        return conferenceRoomService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody ConferenceRoomDto conferenceRoomDto){
        conferenceRoomService.add(conferenceRoomDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public void update(@RequestBody ConferenceRoomDto conferenceRoomDto, @PathVariable Long id){
        conferenceRoomService.update(id,conferenceRoomDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomService.delete(id);
    }
}
