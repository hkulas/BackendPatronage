package com.hubertkulas.backendpatronage.repository;

import com.hubertkulas.backendpatronage.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
