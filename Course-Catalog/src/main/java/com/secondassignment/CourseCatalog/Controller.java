package com.secondassignment.CourseCatalog;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

public class Controller {
    @Autowired
    EurekaClient client;
    @RequestMapping("/")
    public String getCatalogHome() {
        String courseAppMessage="";
        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("FX-courseApp-Service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppMessage = restTemplate.getForObject(courseAppURL,String.class);
        return("Welcome to Futurex Course Ctalaog" + courseAppMessage);
    }

}
