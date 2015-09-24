package com.tz.model.dao;

import com.tz.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hjl on 2015/9/17.
 */
public interface UserDao extends CrudRepository<User, Integer> {
}
