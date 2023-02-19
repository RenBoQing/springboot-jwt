package com.rbq.mapper;

import com.rbq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2023年02月07日 16:42
 * @Description
 */
@Mapper
@Repository
public interface UserMapper {
    User login(User user);
}
