package com.rbq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author RenBoQing
 * @date 2023年02月07日 16:41
 * @Description
 */
@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private String password;
}
