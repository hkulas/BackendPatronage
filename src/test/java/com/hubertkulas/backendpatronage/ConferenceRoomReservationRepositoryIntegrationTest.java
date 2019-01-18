package com.hubertkulas.backendpatronage;

import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
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
public class ConferenceRoomReservationRepositoryIntegrationTest {

    @Autowired
    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    @Test
    public void returnConferenceRoomReservationMock_whenGetOneIsCalled() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        ConferenceRoomReservation conferenceRoomReservationMock = new ConferenceRoomReservation("23", LocalDateTime.parse("1996-12-14 20:50", formatter),
                LocalDateTime.parse("1996-12-14 21:50", formatter));
        conferenceRoomReservationRepository.save(conferenceRoomReservationMock);
        ConferenceRoomReservation conferenceRoomReservationCall = conferenceRoomReservationRepository.getOne(1l);
        assertThat(conferenceRoomReservationCall)
                .isEqualTo(conferenceRoomReservationMock);
    }


}
