package com.bowen.architecture.architecture1.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

public class JsonHelper {

    private JsonHelper(){}

    public static String object2str(Object obj){
        String reStr = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            reStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    public static Object str2Object(String str, Class cls){
        Object retObj = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            retObj = mapper.readValue(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retObj;
    }
}
