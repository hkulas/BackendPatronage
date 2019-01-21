package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.RoomReservationDto;
import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import com.hubertkulas.backendpatronage.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConferenceRoomReservations")
public class RoomReservationController {

    @Autowired
    private Service<RoomReservationDto> roomReservationService;

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @GetMapping("/{id}")
    public RoomReservationDto get(@PathVariable Long id){
        return roomReservationService.get(id);

    }
    @GetMapping()
    public List<RoomReservationDto> getAll(){
        return roomReservationService.getAll();
    }

    @PostMapping
    public void add(@RequestBody RoomReservationDto roomReservationDto){
        roomReservationService.add(roomReservationDto);
    }

    @PutMapping(value ="/{id}")
    public void update(@RequestBody RoomReservationDto roomReservationDto, @PathVariable Long id){
      roomReservationService.update(id, roomReservationDto);

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        roomReservationService.delete(id);
    }

}
