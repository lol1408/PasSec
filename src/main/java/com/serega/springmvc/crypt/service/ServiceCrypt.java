package com.serega.springmvc.crypt.service;

/**
 * Interface for encode and decode String date
 *
 * @author Makarenko Sergey
 * @version 1.0
 *
 */
public interface ServiceCrypt {

    public String enCode(String str);
    public String deCode(String str);

}
