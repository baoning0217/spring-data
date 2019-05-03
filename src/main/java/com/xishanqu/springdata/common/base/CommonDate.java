package com.xishanqu.springdata.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Function:
 * @Author: BaoNing
 * @Date: 2019-04-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDate {

    @Field(value = "create_date")
    private Date createDate = new Date();

    @Field(value = "update_date")
    private Date updateDate;

}
