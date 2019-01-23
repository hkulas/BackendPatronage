package com.hubertkulas.backendpatronage;

import com.hubertkulas.backendpatronage.model.RoomReservation;
import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomReservationTest {

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Test
    public void returnRoomReservationSample_whenGetOneIsCalled() {
        var reservationRoomSample = roomReservationRepository.save(createSampleRoom());
        var reservationRoomResult = roomReservationRepository.getOne(1l);
        assertThat(reservationRoomResult)
                .isEqualTo(reservationRoomSample);
    }

    private RoomReservation createSampleRoom() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var reservationRoom = new RoomReservation("23", LocalDateTime.parse("1996-12-14 20:50", formatter),
                LocalDateTime.parse("1996-12-14 21:50", formatter));
        return reservationRoom;
    }
}
