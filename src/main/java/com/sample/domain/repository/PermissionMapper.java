package com.sample.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.domain.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author zengfeiyue
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
