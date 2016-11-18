package com.serega.springmvc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by sergey on 17.10.16.
 */
public class Convert {

    public static String resourceToJSON(Resource resource) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(resource);
        return string;
    }
    public static String resourcesToJSON(List<Resource> list) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(list);

    }
    public static User jsonToUser(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, User.class);
    }
    public static Resource jsonToResource(String json) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Resource.class);
    }

}
