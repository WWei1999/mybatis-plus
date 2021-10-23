package com.atguigu.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 20:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "product")
public class Product {
    @TableId(value = "id",type = IdType.NONE)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private Integer price;

    @Version
    @TableField(value = "version")
    private Integer version;

    @TableField(value = "is_deleted")
    private Integer deleted;
}
