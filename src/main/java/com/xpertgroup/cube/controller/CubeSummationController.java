package com.xpertgroup.cube.controller;

import com.xpertgroup.cube.input.InputQuery;
import com.xpertgroup.cube.input.InputUpdate;
import com.xpertgroup.cube.service.impl.CubeSummationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CubeSummationController {

    @Autowired
    CubeSummationServiceImpl cubeSummationService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/calculateSum/", method = RequestMethod.GET)
    public Long calculateSum() {

        InputQuery inputQuery = new InputQuery(1, 1, 1, 1, 1, 1);
        return cubeSummationService.query(inputQuery);
    }

    @RequestMapping(value = "/updateSum/", method = RequestMethod.GET)
    public String updateSum() {
        InputUpdate inputUpdate = new InputUpdate(1, 1, 1, 4);
        return cubeSummationService.update(inputUpdate);
    }

    @RequestMapping(value = "/initialize/", method = RequestMethod.GET)
    public String initialize(@RequestParam Integer size, @RequestParam Integer operations) {

        return cubeSummationService.defineSizeOfCubeAndNumberOfOperations(size, operations);
    }
}
