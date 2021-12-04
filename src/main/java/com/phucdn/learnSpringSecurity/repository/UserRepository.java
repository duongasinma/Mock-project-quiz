package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	@Query(value = "select user_id, address, date_of_create, "
			+ "email, full_name, password, "
			+ "phone, status, role_id "
			+ "from users "
			+ "where user_id = :userId", nativeQuery = true)
	UserEntity findUserAccount(@Param("userId") String userId);

	@Modifying
	@Query(value = "update users set status = 'InActive' "
			+ "where user_id = :userId", nativeQuery = true)
	void banUserByUserId(@Param("userId") String userId);
	
	@Modifying
	@Query(value = "update users set status = 'Active' "
			+ "where user_id = :userId", nativeQuery = true)
	void reActivateUserByUserId(@Param("userId") String userId);
}
