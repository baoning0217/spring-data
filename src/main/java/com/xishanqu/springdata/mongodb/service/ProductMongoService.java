package com.xishanqu.springdata.mongodb.service;

import com.xishanqu.springdata.common.constant.RedisConstant;
import com.xishanqu.springdata.common.dto.ProductDto;
import com.xishanqu.springdata.core.entity.Product;
import com.xishanqu.springdata.mongodb.dao.ProductMongoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Function:
 * @Author: BaoNing
 * @Date: 2019-05-03
 */
@Service
@Slf4j
public class ProductMongoService {

    @Autowired
    private ProductMongoDao productMongoDao;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * save
     * @param product
     * @return
     */
    public Product saveProduct(Product product){
        return productMongoDao.saveProduct(product);
    }


    /**
     * update product stock for mongodb
     * @param productDto
     * @return
     */
    public synchronized boolean orderProduct(ProductDto productDto){
        //获取当前商品的信息
        Product product = productMongoDao.getProductById(productDto.getProductId());

        //检查商品库存
        Integer stock = product.getStock();
        if (stock < 1){
            return false;
        }
        //预定，库存减少
        stock =  stock - 1;
        log.info("stock========"+ stock );

        //保存库存
        boolean result = productMongoDao.updateProductStock(productDto.getProductId(), stock);
        return result;
    }


    /**
     * getProductById
     * @param productDto
     * @return
     */
    public Product getProductById(ProductDto productDto){
        Product product = (Product)redisTemplate.opsForValue().get(RedisConstant.PRODUCT.PRODUCT + productDto.getProductId());
        log.info("getProductForRedis=======redis");
        if (!ObjectUtils.isEmpty(product)){
            return product;
        }
        product = productMongoDao.getProductById(productDto.getProductId());
        log.info("getProductForMongoDB=========mongodb");
        //添加缓存
        redisTemplate.opsForValue().set(RedisConstant.PRODUCT.PRODUCT + product.getId(), product);
        redisTemplate.opsForValue().set(RedisConstant.PRODUCT.PRODUCT_STOCK + product.getId(), product.getStock());
        return product;
    }

    /**
     * order product for redis
     * @param productDto
     * @return
     */
    public Long orderProductForRedis(ProductDto productDto){
        Long decrement = redisTemplate.opsForValue().decrement(RedisConstant.PRODUCT.PRODUCT_STOCK + productDto.getProductId());
        log.info("orderProductForRedis=========" + decrement);
        return decrement;
    }







}
