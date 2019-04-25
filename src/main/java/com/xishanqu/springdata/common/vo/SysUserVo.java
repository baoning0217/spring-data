package com.xishanqu.springdata.common.vo;

import com.xishanqu.springdata.core.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @Author BaoNing 2019/4/25
 */
@Data
public class SysUserVo extends SysUser{

    List<String> address;

}
