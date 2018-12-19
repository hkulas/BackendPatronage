package com.hubertkulas.backendpatronage.service;

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

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    private static final Logger logger = LogManager.getLogger(DataBaseLoader.class);


    public DataBaseLoader(ConferenceRoomReservationRepository conferenceRoomReservationRepository) {
        this.conferenceRoomReservationRepository = conferenceRoomReservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Populated db");
        //conferenceRoomReservationRepository.save(new ConferenceRoomReservation("This is id",dateFormat.parse("1996-12-14"),dateFormat.parse("1997-01-12"),new ConferenceRoom("John","This is room id",3,true,20,30,10)));

    }
}
