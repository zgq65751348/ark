package com.woniu.aberration.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "mobile_phone")
@Data
@Builder
public class MobilePhone {

    private Long id;

    private String brand;

    private String model;

    private String size;

    private BigDecimal price;

    @Field(value = "place_of_origin")
    private String placeOfOrigin;
}
