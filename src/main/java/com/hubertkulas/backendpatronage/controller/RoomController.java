package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.RoomDto;
import com.hubertkulas.backendpatronage.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {



    private final Service<RoomDto> conferenceRoomService;

    public RoomController(Service<RoomDto> conferenceRoomService) {
        this.conferenceRoomService = conferenceRoomService;
    }

    @GetMapping("/{id}")
    public RoomDto get(@PathVariable Long id) {

        return conferenceRoomService.get(id);


    }

    @GetMapping()
    public List<RoomDto> getAll() {
        return conferenceRoomService.getAll();
    }

    @PostMapping
    public RoomDto add(@RequestBody RoomDto roomDto) {
        return conferenceRoomService.add(roomDto);
    }

    @PutMapping(value = "/{id}")
    public RoomDto update(@RequestBody RoomDto roomDto, @PathVariable Long id) {
        return conferenceRoomService.update(id, roomDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        conferenceRoomService.delete(id);
    }
}
