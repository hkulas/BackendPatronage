package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomReservationDto;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
import com.hubertkulas.backendpatronage.service.ConferenceRoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConferenceRoomReservations")
public class ConferenceRoomReservationController {

    @Autowired
    private ConferenceRoomReservationService conferenceRoomReservationService;

    @Autowired
    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    @GetMapping("/{id}")
    public ConferenceRoomReservationDto get(@PathVariable Long id){
        return conferenceRoomReservationService.get(id);

    }
    @GetMapping()
    public List<ConferenceRoomReservationDto> getAll(){
        return conferenceRoomReservationService.getAll();
    }

    @PostMapping
    public void add(@RequestBody ConferenceRoomReservationDto conferenceRoomReservationDto){
        conferenceRoomReservationService.add(conferenceRoomReservationDto);
    }

    @PutMapping(value ="/{id}")
    public void update(@RequestBody ConferenceRoomReservationDto conferenceRoomReservationDto, @PathVariable Long id){
      conferenceRoomReservationService.update(id,conferenceRoomReservationDto);

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomReservationService.delete(id);
    }

}
