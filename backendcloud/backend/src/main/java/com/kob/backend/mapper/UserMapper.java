package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:Smart7 Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
