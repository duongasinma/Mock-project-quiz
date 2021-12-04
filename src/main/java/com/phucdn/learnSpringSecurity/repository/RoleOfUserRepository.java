package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;

@Repository
public interface RoleOfUserRepository extends JpaRepository<RoleOfUserEntity, String>{
	@Query(value = "select role_of_users.role_name \r\n"
			+ "from role_of_users, users\r\n"
			+ "where role_of_users.role_id = users.role_id and\r\n"
			+ "users.user_id = :userId", nativeQuery = true)
	List<String> getRoleNames(@Param("userId") String userId);
	
	@Query(value = "select role_of_users.role_id \r\n"
			+ "from role_of_users, users\r\n"
			+ "where role_of_users.role_id = users.role_id and\r\n"
			+ "users.user_id = :userId", nativeQuery = true)
	List<String> getRoleIDs(@Param("userId") String userId);

}
