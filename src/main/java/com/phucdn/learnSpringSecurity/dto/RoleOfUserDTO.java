package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOfUserDTO implements Serializable{
	private String roleId;
	private String roleName;
	private String statusRole;
}
