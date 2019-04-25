package com.xishanqu.springdata.mongodb.service;

import com.xishanqu.springdata.common.dto.ParamDto;
import com.xishanqu.springdata.common.vo.SysUserVo;
import com.xishanqu.springdata.mongodb.dao.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author BaoNing 2019/4/25
 */
@Service
public class UserMongoService {

    @Autowired
    private UserMongoDao userMongoDao;


    /**
     * addSysUser
     * @param sysUserVo
     * @return SysUserVo
     */
    public SysUserVo addSysUser(SysUserVo sysUserVo){
        return userMongoDao.addSysUser(sysUserVo);
    }

    /**
     * findSysUserById
     * @param sysUserId
     * @return SysUserVo
     */
    public SysUserVo findSysUserById(String sysUserId){
        return userMongoDao.findSysUserById(sysUserId);
    }

    /**
     * editSysUser
     * @param sysUserVo
     * @return
     */
    public SysUserVo editSysUser(SysUserVo sysUserVo){
        return  userMongoDao.editSysUser(sysUserVo);
    }

    /**
     * updateSysUser
     * @param paramDto
     * @return
     */
    public Integer updateSysUser(ParamDto paramDto){
        return  userMongoDao.updateSysUser(paramDto);
    }


}
