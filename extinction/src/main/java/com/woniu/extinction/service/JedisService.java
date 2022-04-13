package com.woniu.extinction.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Date;

@Service
public class JedisService {

    @Autowired
    private JedisCluster jedisCluster;

    public JSONObject addKey(String key) {
        jedisCluster.set(key, new Date() + "");
        JSONObject json = new JSONObject();
        json.put("key", key);
        json.put("value", jedisCluster.get(key));
        return json;
    }

    public JSONObject delKey(String key) {
        jedisCluster.del(key);
        JSONObject json = new JSONObject();
        json.put(key + "是否存在?", jedisCluster.exists(key));
        return json;
    }
}
