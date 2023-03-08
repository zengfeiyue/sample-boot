package com.sample.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 *
 * @author zengfeiyue
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    Page<SysUser> selectAll(Pageable pageable);
}
