package hn.jiah.apivalidatorbean.controller;

import hn.jiah.apivalidatorbean.dto.ResultPojo;
import hn.jiah.apivalidatorbean.dto.SimplePojo;
import hn.jiah.apivalidatorbean.dto.SimplePojoV2;
import hn.jiah.apivalidatorbean.dto.SimplePojoV3;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/validator/")
public class ValidatorController {

    @PostMapping(value = "simple", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultPojo validate(@Valid @RequestBody SimplePojo simplePojo){
        return ResultPojo.builder()
                .code(0)
                .message("OK").build();
    }

    @PostMapping(value = "simple2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultPojo validate(@Valid @RequestBody SimplePojoV2 simplePojo){
        return ResultPojo.builder()
                .code(0)
                .message("OK").build();
    }

    @PostMapping(value = "simple3", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultPojo validate(@Valid @RequestBody SimplePojoV3 simplePojo){
        return ResultPojo.builder()
                .code(0)
                .message("OK").build();
    }

}
