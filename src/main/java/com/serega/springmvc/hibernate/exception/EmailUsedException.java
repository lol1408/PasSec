package com.serega.springmvc.hibernate.exception;

/**
 * Created by sergey on 14.11.16.
 */
public class EmailUsedException extends Exception {

    @Override
    public String getMessage() {
        return "thi email already use";
    }

    public EmailUsedException(Throwable e){
        initCause(e);
    }
}
