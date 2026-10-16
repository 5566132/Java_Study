package com.heima.logging.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@Slf4j
@RestController
@ResponseBody
public class Controller {



    @GetMapping("/h")
    public String handle01(){


       /* log.trace("Trace......");
        log.debug("Debug......");

        log.info("Info.......");
        log.warn("Warn.......");
        log.error("Error.......");*/




        return "Hello!!";
    }

}
