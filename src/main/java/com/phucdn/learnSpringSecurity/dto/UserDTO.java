package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
	@Pattern(regexp = "^[0-9]{8,12}$", message = "please enter a valid Phone!")
	private String phone;
	@Email(message = "please enter a valid e-mail address")
	private String email;
	@Pattern(regexp = "[a-zA-Z1-9_\\s]+", message = "please enter a valid address!")
	private String address;
	private String status;
	private String roleId;
}
