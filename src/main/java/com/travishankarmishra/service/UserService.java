package com.travishankarmishra.service;

import com.travishankarmishra.model.User;

public interface UserService {

	boolean Insert(User u);
	
	String fetch(User u);
	
}
