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

    @GetMapping("/{id}")
    public ConferenceRoomDto get(@PathVariable Long id){

            return conferenceRoomService.get(id);


    }
    @GetMapping()
    public List<ConferenceRoomDto> getAll(){
        return conferenceRoomService.getAll();
    }

    @PostMapping
    public void add(@RequestBody ConferenceRoomDto conferenceRoomDto){
        conferenceRoomService.add(conferenceRoomDto);
    }

    @PutMapping(value ="/{id}")
    public void update(@RequestBody ConferenceRoomDto conferenceRoomDto, @PathVariable Long id){
        conferenceRoomService.update(id,conferenceRoomDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomService.delete(id);
    }
}
