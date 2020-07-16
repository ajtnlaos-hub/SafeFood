package com.ssafy.safefood.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Allergy;
import com.ssafy.safefood.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	SqlSession session;
	private final String namespace = "sql.safefood.user.";
	@Override
	public User selectUser(User user) {
		return session.selectOne(namespace.concat("selectUser"), user);
	}
	@Override
	public User selectUserDetail(String id) {
		return session.selectOne(namespace.concat("selectUserDetail"), id);
	}
	@Override
	public boolean updateUser(User user) {
		return session.update(namespace.concat("updateUser"), user)>0;
	}
	@Override
	public boolean insertUserAllergy(Allergy allergy) {
		return session.insert(namespace.concat("insertUserAllergy"), allergy)>0;
	}
	@Override
	public boolean deleteUserAllergy(String id) {
		int result = session.delete(namespace.concat("deleteUserAllergy"), id);
		return result>=0;
	}
	@Override
	public boolean insertUser(User user) {
		return session.insert(namespace.concat("insertUser"), user)>0;
	}
	@Override
	public boolean deleteUser(String id) {
		return session.delete(namespace.concat("deleteUser"), id)>0;
	}
}
