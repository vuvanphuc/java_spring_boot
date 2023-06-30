package com.example.core.repository;

import com.example.core.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * User repository.
 */
@Mapper
public interface UserRepository {

  List<User> findAll();

  List<User> find(User user);

  Long create(User user);

  Long update(User user);

  Long delete(Long id);
}