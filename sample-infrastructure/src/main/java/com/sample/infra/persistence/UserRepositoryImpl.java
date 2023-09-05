package com.sample.infra.persistence;

import com.sample.domain.model.entity.UserEntity;
import com.sample.domain.repository.UserRepository;
import com.sample.infra.persistence.jpa.UserJpaRepository;
import com.sample.infra.persistence.po.UserPO;
import com.sample.infra.persistence.po.UserPOAssembler;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 用户仓储
 *
 * @author laiqiao
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserJpaRepository userJpaRepository;

    @Override
    public void delete(Integer id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public UserEntity getById(Integer id) {
        Optional<UserPO> byId = userJpaRepository.findById(id);
        UserPO po = byId.orElse(null);
        return UserPOAssembler.INSTANCE.toEntity(po);

    }

    @Override
    public UserEntity save(UserEntity s) {
        UserPO userPO = UserPOAssembler.INSTANCE.toPo(s);
        UserPO save = userJpaRepository.save(userPO);
        return UserPOAssembler.INSTANCE.toEntity(save);
    }

    @Override
    public UserEntity findByAccount(String account) {
        UserPO po = userJpaRepository.findByAccount(account);
        UserEntity userEntity = UserPOAssembler.INSTANCE.toEntity(po);
        return userEntity;
    }
}
