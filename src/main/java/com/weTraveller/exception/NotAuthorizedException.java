package com.weTraveller.exception;


public class NotAuthorizedException extends ServiceException{
    public NotAuthorizedException() {
        super("exception.not_authorized");
    }
}
