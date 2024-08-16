package com.example.calculator.controller;

import com.example.calculator.service.CalculatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorServiceImpl service;

    public CalculatorController(CalculatorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
    public String hello() {
        return service.hello();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Integer num1,
                       @RequestParam("num2") Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Отсутствует один из параметров");
        }
        return service.plus(num1, num2);

    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Введите второе значение";
        } else {
            return service.minus(num1, num2);
        }
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Введите второе значение";
        } else {
            return service.multiply(num1, num2);
        }
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1,
                         @RequestParam(value = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Введите второе значение";
        }

        return service.divide(num1, num2);
    }
}

