package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.service.ConferenceRoomReservationService;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ConferenceRoomReservationController {

    @Autowired
    private ConferenceRoomReservationService conferenceRoomReservationService;

    @RequestMapping("/conferenceRoom/{id}")
    public ConferenceRoomReservation get(@PathVariable Long id){
        return conferenceRoomReservationService.get(id);

    }
    @RequestMapping("/conferenceRoom")
    public List<ConferenceRoomReservation> getAll(){
        return conferenceRoomReservationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/conferenceRoom")
    public void add(ConferenceRoomReservation conferenceRoomReservation){
        conferenceRoomReservationService.add(conferenceRoomReservation);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/conferenceRoom/{id}")
    public void update(@PathVariable Long id, ConferenceRoomReservation conferenceRoomReservation){
        conferenceRoomReservationService.update(id,conferenceRoomReservation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/conferenceRoom/{id}")
    public void delete(@PathVariable Long id){
        conferenceRoomReservationService.delete(id);
    }

}
