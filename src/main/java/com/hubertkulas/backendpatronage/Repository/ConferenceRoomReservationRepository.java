package com.hubertkulas.backendpatronage.Repository;

import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRoomReservationRepository extends JpaRepository<ConferenceRoomReservation,Long> {
}
