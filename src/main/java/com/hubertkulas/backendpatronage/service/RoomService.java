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
        var conferenceRooms = roomRepository.findAll();
        var conferenceRoomDtos = new ArrayList<RoomDto>();

        for (Room room : conferenceRooms) {
            RoomDto roomDto = convertToDto(room);
            conferenceRoomDtos.add(roomDto);
        }
        return conferenceRoomDtos;
    }

    @Override
    public RoomDto get(Long id) {
        validateId(id);
        return convertToDto(roomRepository.getOne(id));
    }

    @Override
    public void add(RoomDto roomDto) {
        Room room = convertToEntity(roomDto);
        validateRoomNameIdOfRoom(room);
        roomRepository.save(room);
    }

    @Override
    public void update(Long id, RoomDto roomDto) {
        validateId(id);
        Room room = convertToEntity(roomDto);
        validateRoomNameIdOfRoom(room);
        returnUpdate(id, room);


    }

    @Override
    public void delete(Long id) {
        validateId(id);
        roomRepository.deleteById(id);
    }

    private void validateRoomNameIdOfRoom(Room room) {
        List<Room> rooms = roomRepository.findAll();

        rooms.forEach(newRoom -> {
            if (newRoom.getRoomName().equals(room.getRoomName())) {
                throw new IllegalArgumentException("'room name' field is not unique");
            }
            if (newRoom.getIdOfRoom().equals(room.getIdOfRoom())) {
                throw new IllegalArgumentException("'id of room' field is not unique");
            }
        });

    }

    private void validateId(Long id) {
        if (id > roomRepository.findAll().size()) {
            throw new IllegalArgumentException("Conference room with specified id does not exist");
        }
    }

    private RoomDto convertToDto(Room room) {
        var conferenceRoomDto = new RoomDto();
        BeanUtils.copyProperties(room, conferenceRoomDto);
        return conferenceRoomDto;
    }

    private Room convertToEntity(RoomDto roomDto) {

        var conferenceRoom = new Room();
        try {
            BeanUtils.copyProperties(roomDto, conferenceRoom);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Objerct with specified id does not exist");
        }
        return conferenceRoom;
    }

    private Room returnUpdate(Long id, Room room) {
        return roomRepository.findById(id).map(newRoom -> {
            newRoom.setRoomName(room.getRoomName());
            newRoom.setIdOfRoom(room.getIdOfRoom());
            newRoom.setFloor(room.getFloor());
            newRoom.setIsAvailable(room.getIsAvailable());
            newRoom.setStandingPlaces(room.getStandingPlaces());
            newRoom.setSeats(room.getSeats());
            newRoom.setHangingPlaces(room.getSeats());
//            newRoom.setRoomEquipment(room.getRoomEquipment());

            return roomRepository.save(newRoom);
        }).orElseGet(() -> {
            room.setId(id);
            return roomRepository.save(room);
        });
    }


}
