package hn.jiah.apirestcache.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/refresh")
public class RefreshCacheController {

    @GetMapping(value = "/")
    @CacheEvict(value="counterLetters", allEntries=true)
    public void refreshCache(){

    }
}
