package demo.controller;

import demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello spring cloud from eureka";
    }

    @GetMapping(value = "/string")
    public String string(){
        return "string";
    }

    @GetMapping(value = "/stringJsonUtf8", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String stringJson(){
        return "string";
    }

    @GetMapping(value = "/map")
    public String map(){
        return "{\"key\" : \"value\"}";
    }

    @GetMapping(value = "/mapJsonUtf8", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String mapJsonUtf8(){
        return "{\"key\" : \"value\"}";
    }

    @GetMapping(value = "/user")
    public User user(){
        User user = new User("foo", 10);
        return user;
    }

    @GetMapping(value = "/userJsonUtf8", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User userJsonUtf8(){
        User user = new User("bar", 12);
        return user;
    }
}
