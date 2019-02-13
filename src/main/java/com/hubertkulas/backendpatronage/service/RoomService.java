package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.RoomDto;
import com.hubertkulas.backendpatronage.model.Room;
import com.hubertkulas.backendpatronage.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements com.hubertkulas.backendpatronage.service.Service<RoomDto> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomDto> getAll() {
        var rooms = roomRepository.findAll();
        var roomDtos = new ArrayList<RoomDto>();

        rooms.forEach(room->{
            RoomDto roomDto = convertToDto(room);
            roomDtos.add(roomDto);
        });
        return roomDtos;
    }

    @Override
    public RoomDto get(Long id) {

        return convertToDto(roomRepository.getOne(id));
    }

    @Override
    public RoomDto add(RoomDto roomDto) {
        Room room = convertToEntity(roomDto);
        room = roomRepository.save(room);
        return convertToDto(room);
    }

    @Override
    public RoomDto update(Long id, RoomDto roomDto) {
        Room room = convertToEntity(roomDto);
        return roomRepository.findById(id).map(newRoom -> {
            newRoom.setRoomName(room.getRoomName());
            newRoom.setIdOfRoom(room.getIdOfRoom());
            newRoom.setFloor(room.getFloor());
            newRoom.setAvailable(room.getAvailable());
            newRoom.setStandingPlaces(room.getStandingPlaces());
            newRoom.setSeats(room.getSeats());
            newRoom.setHangingPlaces(room.getSeats());
            newRoom.setRoomEquipment(room.getRoomEquipment());
            newRoom = roomRepository.save(newRoom);
            return convertToDto(newRoom);
        }).orElseGet(() -> {
            room.setId(id);
            Room room1 = roomRepository.save(room);
            return convertToDto(room1);
        });

    }

    @Override
    public void delete(Long id) {

        roomRepository.deleteById(id);
    }

    private RoomDto convertToDto(Room room) {
        var roomDto = new RoomDto();
        BeanUtils.copyProperties(room, roomDto);
        return roomDto;
    }

    private Room convertToEntity(RoomDto roomDto) {

        var room = new Room();
        BeanUtils.copyProperties(roomDto, room);
        return room;
    }


}
