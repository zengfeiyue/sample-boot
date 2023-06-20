package com.sample.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 *
 * @author zengfeiyue
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Page<User> selectAll(Pageable pageable);
}
