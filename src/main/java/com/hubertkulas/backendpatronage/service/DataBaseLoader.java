package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.model.ConferenceRoomEquipment;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomRepository;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Component
public class DataBaseLoader implements CommandLineRunner {

    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;
    private OrganizationRepository organizationRepository;
    private ConferenceRoomRepository conferenceRoomRepository;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static final Logger logger = LogManager.getLogger(DataBaseLoader.class);


    public DataBaseLoader(ConferenceRoomReservationRepository conferenceRoomReservationRepository, OrganizationRepository organizationRepository, ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomReservationRepository = conferenceRoomReservationRepository;
        this.organizationRepository = organizationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Populated db");


        var conferenceRoomsIBM = new ArrayList<ConferenceRoom>();

        conferenceRoomsIBM.add(new ConferenceRoom("BlueRoom", "10", 1, true, 20, 30, 0,
                   new ConferenceRoomEquipment("Alfa", true, 56, "+12 123123123",ConferenceRoomEquipment.ConnectionType.Bluetooth)));
        conferenceRoomsIBM.add(new ConferenceRoom("RedWall", "20", 2, true, 20, 10, 0,
                    new ConferenceRoomEquipment("Beta", true, 31, "+14 321321321",ConferenceRoomEquipment.ConnectionType.Bluetooth)));

        ArrayList<ConferenceRoom> conferenceRoomsGoogle = new ArrayList<>();
        conferenceRoomsGoogle.add( new ConferenceRoom("OrangeRoom", "22", 2, true, 15, 5, 0,
                    new ConferenceRoomEquipment("Gamma", true, 12, "+12 147103103",ConferenceRoomEquipment.ConnectionType.USB)));
        conferenceRoomsGoogle.add( new ConferenceRoom("WideRoom", "40", 4, true, 15, 8, 6,
                    new ConferenceRoomEquipment("Delta", false, 99, "+12 999999999",ConferenceRoomEquipment.ConnectionType.Bluetooth)));
        conferenceRoomsGoogle.add( new ConferenceRoom("SpecialRoom", "41", 4, true, 25, 22, 3,
                new ConferenceRoomEquipment("Delta", true, 99, "+12 987654321",ConferenceRoomEquipment.ConnectionType.Bluetooth)));

        organizationRepository.save(new Organization("IBM",conferenceRoomsIBM));
        organizationRepository.save(new Organization("Google",conferenceRoomsGoogle));
        organizationRepository.save(new Organization("Red Hat"));
        organizationRepository.save(new Organization("Oracle"));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("23", LocalDateTime.parse("1996-12-14 20:50", formatter),
                LocalDateTime.parse("1996-12-14 21:50", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("1345", LocalDateTime.parse("2018-07-14 14:00", formatter),
                LocalDateTime.parse("2018-07-14 15:00", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("9875", LocalDateTime.parse("2018-09-14 10:00", formatter),
                LocalDateTime.parse("2018-09-14 18:00", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("20258", LocalDateTime.parse("2018-07-15 16:00", formatter),
                LocalDateTime.parse("2018-07-15 16:30", formatter)));


    }
}
