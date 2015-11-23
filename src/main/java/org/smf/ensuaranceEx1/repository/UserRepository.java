package org.smf.ensuaranceEx1.repository;

import org.smf.ensuaranceEx1.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shehan on 11/22/2015.
 */
@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}