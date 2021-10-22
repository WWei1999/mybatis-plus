package com.atguigu.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO：来自GitHub
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 8:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User {
    @TableId(value = "id",type = IdType.NONE)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private Integer age;
    @TableField(value = "email")
    private String email;
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_deleted")
    private Integer deleted;
}
