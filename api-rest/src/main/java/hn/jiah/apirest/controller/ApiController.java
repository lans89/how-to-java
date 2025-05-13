package hn.jiah.apirest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/api")
@RestController
public class ApiController {

    @GetMapping(value = "/", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> myMethod(){
        return ResponseEntity.ok("Hola mundo");
    }



}
