package com.hubertkulas.backendpatronage.repository;

import com.hubertkulas.backendpatronage.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByRoomName(String roomName);
    List<Room> findByIdOfRoom(String idOfRoom);
}
