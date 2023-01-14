package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.UserList;

@Mapper
public interface UserMapper {

	List<UserList> findUser();

	UserList targetUser(int user_id);
	
	UserList emailFindUser(String mail);

	void createUser(UserList userList);

	void editUser(UserList userList);

	void deleteUser(int user_id);
	
	void emailDeleteUesr(String mail);
	
}