package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_of_users")
public class RoleOfUserEntity implements Serializable{
	@Id
	@Column(name = "role_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String roleId;
	@Column(name = "role_name", columnDefinition = "nvarchar(50) null")
	private String roleName;
	@Column(name = "status_role", columnDefinition = "nvarchar(50) null")
	private String statusRole;
	
	@OneToMany(mappedBy = "roleUser")
	private Set<UserEntity> users;
}
