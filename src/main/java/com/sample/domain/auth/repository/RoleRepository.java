package com.sample.domain.auth.repository;

import com.sample.infra.repository.po.RolePO;

/**
 * 角色仓储接口
 * @author zengfeiyue
 */
public interface RoleRepository {
    /**
     * 加载角色
     *
     * @param roleId
     * @return
     */
    RolePO load(String roleId);
}
