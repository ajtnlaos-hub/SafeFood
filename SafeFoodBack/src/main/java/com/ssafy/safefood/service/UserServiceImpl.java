package com.ssafy.safefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository uRepo;
	@Override
	public User login(String id) {
		return uRepo.selectUserDetail(id);
	}
	
	@Override
	@Transactional
	public boolean modify(User user) {
		boolean[] isComplete = new boolean[user.getAllergyList().size()+2];
		isComplete[0] = uRepo.updateUser(user);
		isComplete[1] = uRepo.deleteUserAllergy(user.getId());
		for (int i = 0; i < user.getAllergyList().size(); i++) {
			isComplete[2+i] = uRepo.insertUserAllergy(user.getAllergyList().get(i));
		}
		for (int i = 0; i < isComplete.length; i++) {
			if(!isComplete[i]) return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean signUp(User user) {
		boolean[] isComplete = new boolean[user.getAllergyList().size()+1];
		isComplete[0] = uRepo.insertUser(user);
		for (int i = 0; i < user.getAllergyList().size(); i++) {
			isComplete[1+i] = uRepo.insertUserAllergy(user.getAllergyList().get(i));
		}
		for (int i = 0; i < isComplete.length; i++) {
			if(!isComplete[i]) return false;
		}
		return true;
	}
	@Override
	@Transactional
	public boolean delete(String id) {
		boolean deleteAllergyTable = uRepo.deleteUserAllergy(id);
		boolean deleteUserTable = uRepo.deleteUser(id);
		return deleteUserTable&&deleteAllergyTable;
	}
	@Override
	public User findPassword(User user) {
		return uRepo.selectUser(user);
	}
}
