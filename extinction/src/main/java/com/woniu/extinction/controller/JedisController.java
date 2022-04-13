package com.woniu.extinction.controller;

import com.alibaba.fastjson.JSONObject;
import com.woniu.extinction.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jedis")
public class JedisController {

    @Autowired
    private JedisService jedisService;

    @GetMapping("/add/{key}")
    public JSONObject addKey(@PathVariable String key) {
        return jedisService.addKey(key);
    }

    @GetMapping("/del/{key}")
    public JSONObject delKey(@PathVariable String key) {
        return jedisService.delKey(key);
    }
}
