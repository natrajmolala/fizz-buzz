package com.fizzbuzz.controller;

import com.fizzbuzz.service.FizzBuzz;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FizzBuzzController {

    @Autowired
    private FizzBuzz service;

    @RequestMapping(value = "/fizzbuzz/{number}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JsonResponse getFizzBuzz(@PathVariable("number") String number) {

        return new JsonResponse(StringUtils.isNumeric(number)
                ? service.call(Integer.parseInt(number))
                : "Invalid request param!");
    }
}
