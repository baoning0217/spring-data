package com.xishanqu.springdata.mongodb.dao;

import com.xishanqu.springdata.common.dto.ParamDto;
import com.xishanqu.springdata.common.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @Author BaoNing 2019/4/25
 */
@Component
public class UserMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * addSysUser
     * @param sysUserVo
     * @return SysUserVo
     */
    public SysUserVo addSysUser(SysUserVo sysUserVo){
        return mongoTemplate.save(sysUserVo);
    }


    /**
     * findSysUserById
     * @param sysUserId
     * @return SysUserVo
     */
    public SysUserVo findSysUserById(String sysUserId){
        return mongoTemplate.findById(sysUserId, SysUserVo.class);
    }

    /**
     * editSysUser
     * @param sysUserVo
     * @return SysUserVo
     */
    public SysUserVo editSysUser(SysUserVo sysUserVo){
        Query query = new Query(Criteria.where("id").is(sysUserVo.getId()));
        Update update = new Update().set("name",sysUserVo.getName());

        //SysUserVo userVo = mongoTemplate.findAndModify(query, update, SysUserVo.class);

        mongoTemplate.updateFirst(query, update, SysUserVo.class);

        return sysUserVo;
    }


    /**
     * updateSysUser
     * @param paramDto
     * @return SysUserVo
     */
    public Integer updateSysUser(ParamDto paramDto){
        Query query = new Query(Criteria.where("id").is(paramDto.getUserId()));
        Update update = new Update().set("name",paramDto.getName());
        Integer modifiedCount = (int) mongoTemplate.updateFirst(query, update, SysUserVo.class).getModifiedCount();
        return modifiedCount;
    }



}
