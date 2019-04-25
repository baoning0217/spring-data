package com.xishanqu.springdata.mongodb.controller;

import com.xishanqu.springdata.common.base.ResultEntity;
import com.xishanqu.springdata.common.constant.CodeConstant;
import com.xishanqu.springdata.common.constant.ExceptionConstant;
import com.xishanqu.springdata.common.dto.ParamDto;
import com.xishanqu.springdata.common.vo.SysUserVo;
import com.xishanqu.springdata.mongodb.service.UserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author BaoNing 2019/4/25
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserMongoController {

    @Autowired
    private UserMongoService userMongoService;


    /**
     * addSysUser
     * @param sysUserVo
     * @return
     */
    @PostMapping("/addSysUser")
    public ResultEntity addSysUser(@RequestBody SysUserVo sysUserVo){
        if (ObjectUtils.isEmpty(sysUserVo)){
            return new ResultEntity(CodeConstant.CODE.ERROR, ExceptionConstant.REQUEST.LACK_REQUEST_PARAM);
        }
        return new ResultEntity(userMongoService.addSysUser(sysUserVo));
    }

    /**
     * findSysUserById
     * @param sysUserVo
     * @return
     */
    @PostMapping("/findSysUserById")
    public ResultEntity findSysUserById(@RequestBody SysUserVo sysUserVo){
        if (ObjectUtils.isEmpty(sysUserVo)){
            return new ResultEntity(CodeConstant.CODE.ERROR, ExceptionConstant.REQUEST.LACK_REQUEST_PARAM);
        }
        return new ResultEntity(userMongoService.findSysUserById(sysUserVo.getId()));
    }

    /**
     * editSysUser
     * @param sysUserVo
     * @return
     */
    @PostMapping("/editSysUser")
    public ResultEntity editSysUser(@RequestBody SysUserVo sysUserVo){
        if (ObjectUtils.isEmpty(sysUserVo)){
            return new ResultEntity(CodeConstant.CODE.ERROR, ExceptionConstant.REQUEST.LACK_REQUEST_PARAM);
        }
        return new ResultEntity(userMongoService.editSysUser(sysUserVo));
    }


    /**
     * updateSysUser
     * @param paramDto
     * @return
     */
    @PostMapping("/updateSysUser")
    public ResultEntity updateSysUser(@RequestBody ParamDto paramDto){
        if (ObjectUtils.isEmpty(paramDto)){
            return new ResultEntity(CodeConstant.CODE.ERROR, ExceptionConstant.REQUEST.LACK_REQUEST_PARAM);
        }
        return new ResultEntity(userMongoService.updateSysUser(paramDto));
    }



}
