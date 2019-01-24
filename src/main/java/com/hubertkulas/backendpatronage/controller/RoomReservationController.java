package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.RoomReservationDto;
import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import com.hubertkulas.backendpatronage.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class RoomReservationController {


    private final Service<RoomReservationDto> roomReservationService;


    public RoomReservationController(Service<RoomReservationDto> roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @GetMapping("/{id}")
    public RoomReservationDto get(@PathVariable Long id) {
        return roomReservationService.get(id);

    }

    @GetMapping()
    public List<RoomReservationDto> getAll() {
        return roomReservationService.getAll();
    }

    @PostMapping()
    public RoomReservationDto add(@RequestBody RoomReservationDto roomReservationDto) {
        return roomReservationService.add(roomReservationDto);
    }

    @PutMapping(value = "/{id}")
    public RoomReservationDto update(@RequestBody RoomReservationDto roomReservationDto, @PathVariable Long id) {
        return roomReservationService.update(id, roomReservationDto);

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        roomReservationService.delete(id);
    }

}
