package com.signature.api.controller;

import com.signature.api.model.Level;
import com.signature.api.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @RequestMapping({"", "/"})
    public Message welcome() {
        return new Message(Level.INFO, "Welcome, This is Student RESTful Web Service API");
    }
}