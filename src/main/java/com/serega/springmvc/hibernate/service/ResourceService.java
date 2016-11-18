package com.serega.springmvc.hibernate.service;

import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;


import java.util.List;

/**
 * Service class for {@link Resource}.
 *
 * @author Makarenko Sergey
 * @version 1.0
 */
public interface ResourceService {

    List<Resource> getAllResources();
    void addResource(Resource res);
    void deleteResources(Long id);
    Resource findById(Long id);
    void updateResource(Resource res);
    List<Resource> findByUser(User user);


}
