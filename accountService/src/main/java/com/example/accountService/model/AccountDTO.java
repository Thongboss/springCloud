package com.example.accountService.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDTO {
	private Long id;
	
	private String name;
	
	private String password;
	
	private String username;
	
	private Set<String> roles;
}
