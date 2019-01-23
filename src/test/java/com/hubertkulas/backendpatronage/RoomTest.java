package com.hubertkulas.backendpatronage;

import com.hubertkulas.backendpatronage.model.Room;
import com.hubertkulas.backendpatronage.model.RoomEquipment;
import com.hubertkulas.backendpatronage.repository.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void returnRoomSample_whenGetOneIsCalled() {
        var roomSample = roomRepository.save(createSampleRoom());
        var reservationRoomResult = roomRepository.getOne(1l);
        assertThat(reservationRoomResult)
                .isEqualTo(roomSample);
    }

    private Room createSampleRoom() {
        var room = new Room("OrangeRoom", "22", 2, true, 15, 5, 0,
                new RoomEquipment("Gamma", true, 12, "+12 147103103",RoomEquipment.ConnectionType.USB));
        return room ;
    }
}
