package com.sample.domain.auth.entity;

import com.sample.domain.auth.entity.valueobject.RoleId;
import com.sample.domain.auth.repository.RoleRepository;
import com.sample.infra.repository.po.RolePO;

/**
 * 角色
 *
 * @author zengfeiyue
 */
public class Role {

    /**
     * 角色id
     */
    private RoleId roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色聚合仓储接口
     */
    private RoleRepository roleRepository;

    /**
     * 构造领域对象
     *
     * @return
     */
    public static Role of(){
        return new Role();
    }

    /**
     * 加载
     *
     * @return
     */
    public void load(){
        RolePO load = roleRepository.load(this.roleId.toString());
        this.roleName = load.getRoleName();
        this.remark = load.getRemark();
    }
}
