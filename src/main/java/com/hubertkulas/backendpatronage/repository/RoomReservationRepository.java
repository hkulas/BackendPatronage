package com.hubertkulas.backendpatronage.repository;

import com.hubertkulas.backendpatronage.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
