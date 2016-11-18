package com.serega.springmvc.hibernate.service;

import com.serega.springmvc.config.DataBaseConfigTest;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import com.serega.springmvc.hibernate.util.ResourcesFactory;
import com.serega.springmvc.hibernate.util.UserFactory;
import com.serega.springmvc.util.Convert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 17.11.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataBaseConfigTest.class)
@WebAppConfiguration
public class ConvertTest {


    @Test
    public void convertToJsonResource() throws IOException {
        User user = UserFactory.createUser("hello", "0000", "hello.mail");
        Resource resource = ResourcesFactory.createHelloResource(user);
        List<Resource> resources = new ArrayList<>();
        resources.add(resource);
        Convert.resourceToJSON(resource);
        String JsonResource = Convert.resourceToJSON(resource);
        resource = Convert.jsonToResource(JsonResource);
    }
}
