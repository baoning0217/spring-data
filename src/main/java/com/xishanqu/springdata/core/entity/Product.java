package com.xishanqu.springdata.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Function: 商品实体
 * @Author: BaoNing
 * @Date: 2019-05-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "t_product")
public class Product implements Serializable {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "price")
    private Double price;

    @Field(value = "stock")
    private Integer stock;

}
