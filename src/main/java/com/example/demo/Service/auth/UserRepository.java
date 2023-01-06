package com.example.demo.Service.auth;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.UserList;

@Mapper
public interface UserRepository {

	@Select("select * from el_user where user_name = #{username} and delete_flg = 0")
	Optional<UserList>findByUsername(String username);
}