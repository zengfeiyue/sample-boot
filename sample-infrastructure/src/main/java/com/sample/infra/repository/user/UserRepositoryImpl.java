package com.sample.infra.repository.user;


import com.sample.domain.user.model.AuthUser;
import com.sample.domain.user.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * 用户仓储
 *
 * @author laiqiao
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void delete(Integer id) {

    }

    @Override
    public AuthUser getById(Integer id) {
        return null;
    }

    @Override
    public <S extends AuthUser> S save(S s) {
        return null;
    }
}
