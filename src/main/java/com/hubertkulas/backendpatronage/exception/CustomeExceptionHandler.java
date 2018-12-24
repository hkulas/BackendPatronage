package com.hubertkulas.backendpatronage.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> defaultErrorMessage(WebRequest webRequest){

            ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),"Bad Request","Custome Error Message",webRequest.getDescription(false));

            return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    class ErrorMessage{
        private LocalDateTime timeStamp;

        private String error;
        private String message;
        private String details;
        private String path;


        public ErrorMessage(LocalDateTime timeStamp, String error, String message, String details) {
            this.timeStamp = timeStamp;
            this.error = error;
            this.message = message;
            this.details = details;
        }

        public LocalDateTime getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

    }
}
