package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.UserList;
import com.example.demo.Entity.UserList.Authority;
import com.example.demo.Service.UserService;

@SpringBootTest
public class ELBOOKUserTest {

	@Autowired
	private UserService userService;

	//@Disabledをつけることでテストスキップが行える

	@Test
	@Disabled
	//全件取得処理のテストコード
	void findAllTest() {
		//count の値を変えてください
		int count = 2;
		List<UserList> userLists = userService.findUser();
		System.out.println(userLists.size());
		assertEquals(count, userLists.size());
	}

	@Test
	@Disabled
	void targetUser() {
		//int select_num = 7;
		//UserList userList = userService.targetUser(select_num);

	}

	@Test
	//@Disabled
	//ユーザー追加処理
	void createUserAdmin() {
		String name = "iijima";
		UserList userList = new UserList();
		userList.setUser_name(name);
		userList.setMail(name + "@com");
		userList.setPass("password");
		userList.setAuthority(Authority.ADMIN);
		userService.createUser(userList);

	}

	@Test
	//@Disabled
	//ユーザー追加処理
	void createUserUser() {
		String name = "niimura";
		UserList userList = new UserList();
		userList.setUser_name(name);
		userList.setMail(name + "@com");
		userList.setPass("password");
		userList.setAuthority(Authority.USER);
		userService.createUser(userList);

	}

	@Test
	@Disabled
	void editUser() {
		UserList userList = new UserList();
		userList.setUser_id(6);
		userList.setUser_name("kamikita");
		userList.setMail("kamikita@com");
		userList.setPass("password");
		userService.editUser(userList);

		assertEquals("kamikita", userList.getUser_name());
		assertEquals("kamikita@com", userList.getMail());
	}

	@Test
	@Disabled
	//ユーザーの削除処理のテストコード
	//deleteflg の上書きを行う為一部処理の変更が必要

	//Todo target user検索においてデリートフラグも取得できるようにする
	void deleteUser() {

		//引数を変えてください
		userService.deleteUser(14);

		//UserList userList = userService.targetUser(14);

	}

}
