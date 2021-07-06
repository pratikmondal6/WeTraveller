package com.example.weTraveller.exception;


public class AlreadyExistException extends ServiceException{
    public AlreadyExistException() {
        super("exception.already_exist");
    }
    public AlreadyExistException(String message) {
        super(message);
    }
}
