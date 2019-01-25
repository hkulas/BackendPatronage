package com.hubertkulas.backendpatronage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Room is already reserved")
public class RoomIsAlreadyReservedException extends RuntimeException {

}
