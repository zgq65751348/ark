package com.woniu.aberration.controller;

import com.woniu.aberration.model.MobilePhone;
import com.woniu.aberration.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/mb")
public class MobilePhoneController {

    @Autowired
    private MobilePhoneService mobilePhoneService;

    @GetMapping(value = "/insert")
    public Collection<MobilePhone> insert(){
        return mobilePhoneService.insert();
    }

    @GetMapping(value = "/find")
    public Collection<MobilePhone> find(){
        return mobilePhoneService.find();
    }
}
