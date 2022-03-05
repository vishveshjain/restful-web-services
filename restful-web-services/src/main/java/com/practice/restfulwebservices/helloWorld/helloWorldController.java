package com.practice.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class helloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "index";
    }
    @GetMapping(path = "/hello-world-method")
    public helloWorldMethod helloWorldMethod1(){
        return new helloWorldMethod("Hi there");
    }
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public helloWorldMethod helloWorldMethod(@PathVariable String name){
        return new helloWorldMethod(String.format("Hi there, %s",name));
    }
    @GetMapping(path = "/hello-world-method-international")
    public helloWorldMethod helloWorldMethod2(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return new helloWorldMethod(messageSource.getMessage("good.morning.message", null, locale));
    }
}
