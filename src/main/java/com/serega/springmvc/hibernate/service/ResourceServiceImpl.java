package com.serega.springmvc.hibernate.service;


import com.serega.springmvc.crypt.service.ServiceCrypt;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serega.springmvc.hibernate.dao.ResourceDao;


import java.util.List;

/**
 * Class implementing interface {@link ResourceService}
 *
 * @author Makarenko Sergey
 * @version 1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;
    @Autowired
    ServiceCrypt serviceCrypt;
    public List<Resource> getAllResources() {

        List<Resource> resources = resourceDao.findAll();
        for(int i=0; i<resources.size(); i++){

            resources.get(i).setPassword(serviceCrypt.deCode(resources.get(i).getPassword()));

        }
        return  resources;
    }

    public void addResource(Resource res) {
        res.setPassword(serviceCrypt.enCode(res.getPassword()));
        resourceDao.saveAndFlush(res);

    }

    public void deleteResources(Long id) {

        resourceDao.delete(id);

    }

    public Resource findById(Long id) {

        Resource resource;
        resource = resourceDao.findOne(id);
        resource.setPassword(serviceCrypt.deCode(resource.getPassword()));
        return resource;

    }

    public void updateResource(Resource res) {

        res.setPassword(serviceCrypt.enCode(res.getPassword()));
        resourceDao.saveAndFlush(res);

    }

    @Override
    public List<Resource> findByUser(User user) {
        return resourceDao.findByUser(user);
    }

}
