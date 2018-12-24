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


@Component
public class DataBaseLoader implements CommandLineRunner {

    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;
    private OrganizationRepository organizationRepository;
    private ConferenceRoomRepository conferenceRoomRepository;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private LocalDateTime localDateTime;

    private static final Logger logger = LogManager.getLogger(DataBaseLoader.class);


    public DataBaseLoader(ConferenceRoomReservationRepository conferenceRoomReservationRepository, OrganizationRepository organizationRepository, ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomReservationRepository = conferenceRoomReservationRepository;
        this.organizationRepository = organizationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Populated db");

        conferenceRoomRepository.save(
                    new ConferenceRoom("BlueRoom", "10", 1, true, 20, 30, 0,
                    new ConferenceRoomEquipment("Alfa", true, 56, "+12 687123123",ConferenceRoomEquipment.ConnectionType.Bluetooth)));
        conferenceRoomRepository.save(
                    new ConferenceRoom("BlueWall", "20", 2, true, 20, 10, 0,
                    new ConferenceRoomEquipment("Beta", true, 31, "+14 123456789",ConferenceRoomEquipment.ConnectionType.Bluetooth)));
        conferenceRoomRepository.save(
                    new ConferenceRoom("OrangeRoom", "22", 2, true, 15, 5, 0,
                    new ConferenceRoomEquipment("Gamma", true, 12, "+12 147103103",ConferenceRoomEquipment.ConnectionType.USB)));
        conferenceRoomRepository.save(
                    new ConferenceRoom("WideRoom", "40", 4, false, 15, 8, 6,
                    new ConferenceRoomEquipment("Delta", false, 99, "+12 999999999",ConferenceRoomEquipment.ConnectionType.Bluetooth)));

        organizationRepository.save(new Organization("Backend Java"));
        organizationRepository.save(new Organization("Backend .Net"));
        organizationRepository.save(new Organization("Frontend"));
        organizationRepository.save(new Organization("QA"));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("23", localDateTime.parse("1996-12-14 20:50", formatter),
                localDateTime.parse("1996-12-14 21:50", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("1345", localDateTime.parse("2018-07-14 14:00", formatter),
                localDateTime.parse("2018-07-14 15:00", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("9875", localDateTime.parse("2018-09-14 10:00", formatter),
                localDateTime.parse("2018-09-14 18:00", formatter)));

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("20258", localDateTime.parse("2018-07-15 16:00", formatter),
                localDateTime.parse("2018-07-15 16:30", formatter)));


//        conferenceRoomReservationRepository.save(
//                new ConferenceRoomReservation("1", localDateTime.parse("1996-12-14 20:50", formatter), localDateTime.parse("1996-12-14 21:50", formatter),
//                new ConferenceRoom("BlueRoom", "10", 1, true, 20, 30, 0),
//                new ConferenceRoomEquipment("Alfa", true, 56, "+12 687123123"),
//                new Organization("Backend Java")));
//
//        conferenceRoomReservationRepository.save(
//                new ConferenceRoomReservation("2", localDateTime.parse("2018-07-14 14:00", formatter), localDateTime.parse("2018-07-14 15:00", formatter),
//                new ConferenceRoom("BlueWall", "20", 2, true, 20, 10, 0),
//                new ConferenceRoomEquipment("Beta", true, 31, "+14 123456789"),
//                new Organization("Backend .Net")));
//
//        conferenceRoomReservationRepository.save(
//                new ConferenceRoomReservation("3", localDateTime.parse("2018-09-14 10:00", formatter), localDateTime.parse("2018-09-14 18:00", formatter),
//                new ConferenceRoom("OrangeRoom", "22", 2, true, 15, 5, 0),
//                new ConferenceRoomEquipment("Gamma", true, 12, "+12 147103103"),
//                new Organization("Frontend")));
//
//        conferenceRoomReservationRepository.save(
//                new ConferenceRoomReservation("4", localDateTime.parse("2018-07-15 16:00", formatter), localDateTime.parse("2018-07-15 16:30", formatter),
//                new ConferenceRoom("WideRoom", "40", 4, false, 15, 8, 6),
//                new ConferenceRoomEquipment("Delta", false, 99, "+12 999999999"),
//                new Organization("QA")));


    }
}
