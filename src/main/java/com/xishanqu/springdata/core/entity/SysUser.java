package com.xishanqu.springdata.core.entity;

import com.xishanqu.springdata.common.base.CommonDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Author BaoNing 2019/4/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "t_sys_user")
public class SysUser extends CommonDate implements Serializable{

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "sex")
    private Integer sex;

    @Field(value = "age")
    private Integer age;

    @Field(value = "career")
    private String career;

    @Field(value = "shop_id")
    private String shopId;

}
