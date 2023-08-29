package com.sample.infra.persistence;


import com.sample.domain.model.entity.User;
import com.sample.domain.repository.UserRepository;
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
    public User getById(Integer id) {
        return null;
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }
}
