package com.isw.nhr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class HomeController {

	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

}
