package com.example.demo.controller;

import com.example.demo.atmentity.ATM;
import com.example.demo.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class ATMController   {
    @GetMapping("/hello")
    public String hello() {
        return "HELLO SPRING BOOT..."; //<<< ตอบนาย font end
    }

    @Autowired
    ATMService atmService;
    @RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
    public boolean validPass(@RequestBody ATM model) {
//		System.out.println(acc_pass);
        return atmService.validPass(model.getUser_pass(),model.getUser_name());
    }
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public boolean deposit(@RequestBody ATM model) {
        return atmService.deposit(model);
    }
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public boolean withdraw(@RequestBody ATM model) {
        return atmService.withdraw(model);
    }
    @RequestMapping(value = "/checkMoney", method = RequestMethod.POST)
    public ATM checkMoney(@RequestBody String user_pass) {
        return atmService.checkMoney(user_pass);
    }
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public boolean transfer(@RequestBody ATM model) {
        System.out.println(model.getUser_money()+" user_pass "+model.getUser_pass()+" user_name "
                +model.getUser_name()+" user_id "+model.getUser_id());
        return atmService.transfer(model);
    }
}
