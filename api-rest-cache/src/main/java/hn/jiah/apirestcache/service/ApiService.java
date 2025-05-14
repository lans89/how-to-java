package hn.jiah.apirestcache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ApiService implements IApiService{

    @Override
    @Cacheable(value="counterLetters", unless="#result==null")
    public Integer countLetters(String message) {
        Integer total = message.trim().replaceAll("\\s+", "").length();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException intEx) {
            log.error("error at serivce => {}",intEx.getLocalizedMessage());
        }
        return total;
    }

    @Override
    @CachePut(value="counterLetters", unless="#result==null")
    public Integer countUniqueLetters(String message) {
        message = message.trim().replaceAll("\\s+", "");
        Set<String> letters = new LinkedHashSet<>();
        for(char letter: message.toCharArray()){
            letters.add(String.valueOf(letter));
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException intEx) {
            log.error("error at serivce => {}",intEx.getLocalizedMessage());
        }
        return letters.size();
    }
}
