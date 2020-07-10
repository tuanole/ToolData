package com.mydu.letian.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUserId(String id);
	
	List<User> findByUserName(String name);
	
	List<User> findAll();
}
