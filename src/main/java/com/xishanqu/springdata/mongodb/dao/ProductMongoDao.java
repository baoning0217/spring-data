package com.xishanqu.springdata.mongodb.dao;

import com.xishanqu.springdata.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @Function:
 * @Author: BaoNing
 * @Date: 2019-05-03
 */
@Component
public class ProductMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * save
     * @param product
     * @return
     */
    public Product saveProduct(Product product){
        return mongoTemplate.save(product);
    }


    /**
     * get
     * @param productId
     * @return
     */
    public Product getProductById(String productId){
        Query query = new Query(Criteria.where("id").is(productId));
        Product product = mongoTemplate.findOne(query, Product.class);
        return product;
    }

    /**
     * update stock
     * @param productId
     * @param stock
     */
    public boolean updateProductStock(String productId, Integer stock){
        Query query = new Query(Criteria.where("id").is(productId));
        Update update = new Update().set("stock", stock);
        Product modify = mongoTemplate.findAndModify(query, update, Product.class);
        if (ObjectUtils.isEmpty(modify)){
            return false;
        }
        return true;
    }


}
