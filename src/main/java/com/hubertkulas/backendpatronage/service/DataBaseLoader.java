package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.model.ConferenceRoomEquipment;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Component
public class DataBaseLoader implements CommandLineRunner {

    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static final Logger logger = LogManager.getLogger(DataBaseLoader.class);


    public DataBaseLoader(ConferenceRoomReservationRepository conferenceRoomReservationRepository) {
        this.conferenceRoomReservationRepository = conferenceRoomReservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Populated db");


        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("1",dateFormat.parse("1996-12-14 20:50"),dateFormat.parse("1996-12-14 22:00"),
                                                 new ConferenceRoom("BlueRoom","10",1,true,20,30,0),
                                                 new ConferenceRoomEquipment("Alfa",true,56,"+12 687123123"),
                                                 new Organization("Backend Java")));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("2",dateFormat.parse("1996-10-15 15:00"),dateFormat.parse("1996-10-15 17:00"),
                                                 new ConferenceRoom("BlueWall","20",2,true,20,10,0),
                                                 new ConferenceRoomEquipment("Beta",true,31,"+14 123456789"),
                                                 new Organization("Backend .Net")));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("3",dateFormat.parse("1996-12-17 14:50"),dateFormat.parse("1996-12-17 14:50"),
                                                 new ConferenceRoom("OrangeRoom","22",2,true,15,5,0),
                                                 new ConferenceRoomEquipment("Gamma",true,12,"+12 147103103"),
                                                 new Organization("Frontend")));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("4",dateFormat.parse("1996-12-14 12:00"),dateFormat.parse("1996-12-14 14:00"),
                                                 new ConferenceRoom("WideRoom","40",4,false,15,8,6),
                                                 new ConferenceRoomEquipment("Delta",false,99,"+12 999999999"),
                                                 new Organization("QA")));



    }
}
