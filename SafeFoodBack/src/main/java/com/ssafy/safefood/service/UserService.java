package com.ssafy.safefood.service;

import com.ssafy.safefood.dto.User;

public interface UserService {
	User login(String id);
	boolean modify(User user);
	boolean signUp(User user);
	boolean delete(String id);
	User findPassword(User user);
}