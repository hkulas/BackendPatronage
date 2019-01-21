package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.RoomDto;
import com.hubertkulas.backendpatronage.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConferenceRooms")
public class RoomController {


    @Autowired
    private Service<RoomDto> conferenceRoomService;

    @GetMapping("/{id}")
    public RoomDto get(@PathVariable Long id){

            return conferenceRoomService.get(id);


    }
    @GetMapping()
    public List<RoomDto> getAll(){
        return conferenceRoomService.getAll();
    }

    @PostMapping
    public void add(@RequestBody RoomDto roomDto){
        conferenceRoomService.add(roomDto);
    }

    @PutMapping(value ="/{id}")
    public void update(@RequestBody RoomDto roomDto, @PathVariable Long id){
        conferenceRoomService.update(id, roomDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomService.delete(id);
    }
}
