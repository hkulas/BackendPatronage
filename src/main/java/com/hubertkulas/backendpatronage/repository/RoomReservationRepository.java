package com.hubertkulas.backendpatronage.repository;

import com.hubertkulas.backendpatronage.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
    List<RoomReservation> findByPersonalId(String personalId);
    List<RoomReservation> findAllByStartOfReservationLessThanEqualAndEndOfReservationGreaterThanEqual(LocalDateTime end,LocalDateTime start);
}
