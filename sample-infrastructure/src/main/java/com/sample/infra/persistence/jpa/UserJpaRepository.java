package com.sample.infra.persistence.jpa;

import com.sample.infra.persistence.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户repository
 * @author laiqiao
 */
@Repository
public interface UserJpaRepository extends JpaRepository<UserPO, Integer> {

    /**
     * g
     * @param account
     * @return
     */
    UserPO findByAccount(String account);
}
