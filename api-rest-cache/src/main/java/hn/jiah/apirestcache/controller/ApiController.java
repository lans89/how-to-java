package hn.jiah.apirestcache.controller;

import hn.jiah.apirestcache.service.IApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/v1/api")
@RestController
public class ApiController {

    private final IApiService apiService;

    @PostMapping(value = "/cache", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> myMethod(@RequestBody String message){
        String answer = "the request body has %d letters";
        Integer total = Optional.ofNullable(message)
                .map(msg -> apiService.countLetters(message)).orElse(0);
        return ResponseEntity.ok(String.format(answer, total));
    }

    @PostMapping(value = "/cacheput", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> mySecondMethod(@RequestBody String message){
        String answer = "the request body has %d unique letters";
        Integer total = Optional.ofNullable(message)
                .map(msg -> apiService.countUniqueLetters(message)).orElse(0);
        return ResponseEntity.ok(String.format(answer, total));
    }



}
