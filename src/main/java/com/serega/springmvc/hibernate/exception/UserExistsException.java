package com.serega.springmvc.hibernate.exception;

/**
 * Created by sergey on 14.11.16.
 */
public class UserExistsException extends Exception {

    @Override
    public String getMessage() {
        return "user already exists";
    }

    UserExistsException(Throwable e){
        initCause(e);
    }
}
