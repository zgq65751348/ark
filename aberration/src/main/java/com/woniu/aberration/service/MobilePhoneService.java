package com.woniu.aberration.service;

import cn.hutool.core.util.IdUtil;
import com.woniu.aberration.model.MobilePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MobilePhoneService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Collection<MobilePhone> insert() {
        List<MobilePhone> list = new LinkedList<>();
        list.add(MobilePhone.builder().brand("华为").model("nova 9 SE 4G全网通").size("5.4").price(new BigDecimal("5399.00")).placeOfOrigin("中国").id(IdUtil.getSnowflake().nextId()).build());
        list.add(MobilePhone.builder().brand("华为").model("P50E 4G全网通").size("5.4").price(new BigDecimal("5399.00")).placeOfOrigin("中国").id(IdUtil.getSnowflake().nextId()).build());
        list.add(MobilePhone.builder().brand("华为").model("NZone s7pro 5G手机").size("5.4").price(new BigDecimal("4399.00")).placeOfOrigin("中国").id(IdUtil.getSnowflake().nextId()).build());
        list.add(MobilePhone.builder().brand("华为").model("nova 9 Pro 4G全网通 双3200万前置Vlog镜头").size("163.4mm").price(new BigDecimal("2999.00")).placeOfOrigin("中国").id(IdUtil.getSnowflake().nextId()).build());
        list.add(MobilePhone.builder().brand("华为").model("NZone S7pro\\/S7pro+可选 全网通5G手机 ").size("160.68mm").price(new BigDecimal("4689.00")).placeOfOrigin("中国").id(IdUtil.getSnowflake().nextId()).build());
       return mongoTemplate.insert(list,MobilePhone.class);
    }

    public Collection<MobilePhone> find(){
        Collection<Criteria> criteriaList = new LinkedList<>();
        Query query = new Query();
        MobilePhone mobilePhone = MobilePhone.builder().brand("华为").price(new BigDecimal("3000")).build();
        if(!StringUtils.isEmpty(mobilePhone.getBrand())){
            query.addCriteria(Criteria.where("brand").is(mobilePhone.getBrand()));
        }
        if(!Objects.isNull(mobilePhone.getPrice())){
            query.addCriteria( Criteria.where("price").lte(mobilePhone.getPrice()));
        }
        query.with(new Sort(Sort.Direction.DESC,"id"));
        return mongoTemplate.find(query,MobilePhone.class);
    }
}
