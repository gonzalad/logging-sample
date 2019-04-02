package com.barrycommins;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private static final Log LOGGER = LogFactory.getLog(ProxyController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
        restTemplate.getForEntity("http://localhost:8081?name={name}", String.class, Collections.singletonMap("name", name));
        LOGGER.info("name="+name);
        return "Hello, " + name;
    }
}
