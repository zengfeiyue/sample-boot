package com.sample.infra.repository.user;

import com.sample.domain.user.model.User;
import com.sample.domain.user.repository.UserRepository;

/**
 * 用户仓储
 *
 * @author laiqiao
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void delete(Integer id) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }
}
