package com.ssafy.safefood.repository;

import com.ssafy.safefood.dto.Allergy;
import com.ssafy.safefood.dto.User;

public interface UserRepository {
	User selectUser(User user);
	User selectUserDetail(String id);
	boolean updateUser(User user);
	boolean insertUserAllergy(Allergy allergy);
	boolean deleteUserAllergy(String id);
	boolean insertUser(User user);
	boolean deleteUser(String id);
}
