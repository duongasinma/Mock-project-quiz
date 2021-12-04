package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable{
	private String userId;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private String status;
	private String roleId;
}
