package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomReservationDto;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceRoomReservationServiceImpl implements ConferenceRoomReservationService {


    @Autowired
    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    @Override
    public List<ConferenceRoomReservationDto> getAll() {

        var conferenceRoomReservations = conferenceRoomReservationRepository.findAll();
        var conferenceRoomReservationDtos = new ArrayList<ConferenceRoomReservationDto>();

        for (ConferenceRoomReservation conferenceRoomReservation : conferenceRoomReservations) {
            ConferenceRoomReservationDto conferenceRoomReservationDto = convertToDto(conferenceRoomReservation);
            conferenceRoomReservationDtos.add(conferenceRoomReservationDto);
        }
        return conferenceRoomReservationDtos;

    }

    @Override
    public ConferenceRoomReservationDto get(Long id) {
        validateId(id);
        return convertToDto(conferenceRoomReservationRepository.getOne(id));
    }

    @Override
    public void add(ConferenceRoomReservationDto conferenceRoomReservationDto) {
        ConferenceRoomReservation conferenceRoomReservation = convertToEntity(conferenceRoomReservationDto);
        validatePersonalId(conferenceRoomReservation);
        conferenceRoomReservationRepository.save(conferenceRoomReservation);

    }

    @Override
    public void update(Long id, ConferenceRoomReservationDto conferenceRoomReservationDto) {
        validateId(id);
        ConferenceRoomReservation conferenceRoomReservation = convertToEntity(conferenceRoomReservationDto);
        validatePersonalId(conferenceRoomReservation);
        returnUpdate(id, conferenceRoomReservation);

    }

    @Override
    public void delete(Long id) {
        validateId(id);
        conferenceRoomReservationRepository.deleteById(id);

    }

    private void validatePersonalId(ConferenceRoomReservation conferenceRoomReservation) {
        List<ConferenceRoomReservation> conferenceRoomReservations = conferenceRoomReservationRepository.findAll();

        conferenceRoomReservations.forEach(newConferenceRoomReservation -> {
            if (newConferenceRoomReservation.getPersonalId().equals(conferenceRoomReservation.getPersonalId())) {
                throw new IllegalArgumentException("'personal id' field is not unique");
            }
        });

    }

    private void validateId(Long id) {
        if (id > conferenceRoomReservationRepository.findAll().size()) {
            throw new IllegalArgumentException("Conference room reservation with specified id does not exist");
        }
    }

    private ConferenceRoomReservationDto convertToDto(ConferenceRoomReservation conferenceRoomReservation) {

        var conferenceRoomReservationDto = new ConferenceRoomReservationDto();
        BeanUtils.copyProperties(conferenceRoomReservation, conferenceRoomReservationDto);
        return conferenceRoomReservationDto;
    }

    private ConferenceRoomReservation convertToEntity(ConferenceRoomReservationDto conferenceRoomReservationDto) {

        var conferenceRoomReservation = new ConferenceRoomReservation();
        BeanUtils.copyProperties(conferenceRoomReservationDto, conferenceRoomReservation);
        return conferenceRoomReservation;
    }

    private ConferenceRoomReservation returnUpdate(Long id, ConferenceRoomReservation conferenceRoomReservation) {
        return conferenceRoomReservationRepository.findById(id).map(newConferenceRoomReservation -> {
            newConferenceRoomReservation.setPersonalId(conferenceRoomReservation.getPersonalId());
            newConferenceRoomReservation.setStartOfReservation(conferenceRoomReservation.getStartOfReservation());
            newConferenceRoomReservation.setEndOfReservation(conferenceRoomReservation.getEndOfReservation());
            return conferenceRoomReservationRepository.save(newConferenceRoomReservation);
        }).orElseGet(() -> {
            conferenceRoomReservation.setId(id);
            return conferenceRoomReservationRepository.save(conferenceRoomReservation);
        });
    }


}
