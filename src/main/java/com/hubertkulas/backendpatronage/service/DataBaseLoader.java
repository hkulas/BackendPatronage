package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
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


//        ConferenceRoom conferenceRoom = new ConferenceRoom("John","521512",3,true,20,30,10);
//        ConferenceRoomReservation conferenceRoomReservation = new ConferenceRoomReservation("123",dateFormat.parse("1996-12-14 20:50:50"),dateFormat.parse("1996-12-14 22:00:00"),conferenceRoom);
//        conferenceRoomReservationRepository.save(conferenceRoomReservation);

        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("1",dateFormat.parse("1996-12-14 20:50"),dateFormat.parse("1996-12-14 22:00"),
                                                 new ConferenceRoom("John","10",1,true,20,30,0)));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("2",dateFormat.parse("1996-10-15 15:00"),dateFormat.parse("1996-10-15 17:00"),
                new ConferenceRoom("BlueWall","20",2,true,20,10,0)));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("3",dateFormat.parse("1996-12-17 14:50"),dateFormat.parse("1996-12-17 14:50"),
                new ConferenceRoom("OrangeRoom","22",2,true,15,5,0)));
        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("4",dateFormat.parse("1996-12-14 12:00"),dateFormat.parse("1996-12-14 14:00"),
                new ConferenceRoom("WideRoom","40",4,false,15,8,6)));

//       conferenceRoomReservationRepository.save(new ConferenceRoomReservation("12341",date1,date2,
//                new ConferenceRoom("John","521512",3,true,20,30,10)));

    }
}
