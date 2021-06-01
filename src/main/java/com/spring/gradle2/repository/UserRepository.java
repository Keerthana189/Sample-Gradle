package com.spring.gradle2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.gradle2.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

}
