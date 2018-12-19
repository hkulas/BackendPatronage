//package com.hubertkulas.backendpatronage;
//
//import com.hubertkulas.backendpatronage.model.ConferenceRoom;
//import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
//import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//
//@Component
//public class LoadDataBase implements ApplicationRunner {
//
//    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;
//
//    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//
//    private static final Logger logger = LogManager.getLogger(LoadDataBase.class);
//
//    @Autowired
//    public LoadDataBase(ConferenceRoomReservationRepository conferenceRoomReservationRepository) {
//        this.conferenceRoomReservationRepository = conferenceRoomReservationRepository;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        logger.info("populating db");
//        conferenceRoomReservationRepository.save(new ConferenceRoomReservation("This is id",dateFormat.parse("1996-12-14"),dateFormat.parse("1997-01-12"),new ConferenceRoom("John","This is room id",3,true,20,30,10)));
//    }
//}
