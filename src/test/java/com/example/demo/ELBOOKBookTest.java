package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;

@SpringBootTest
public class ELBOOKBookTest {

	@Autowired
	private BookService bookService;

	//件数取得処理のテスト
	@Test
	@Disabled
	void findBookTest() {

		//DBの件数を入力して一致しているかどうか？
		int count = 2;
		List<BookList> lists = bookService.findBook();
		System.out.println(lists.size());
		assertEquals(count, lists.size());

	}

	//book_idを使用して検索の一致を確認する
	@Test
	@Disabled
	void targetBookTest() {
		//	BookList lists = bookService.targetBook(10);

	}

	@Test
	@Disabled
	void createBook() {
		BookList bookList = new BookList();
		bookList.setBook_name("じゃんけんで５０連勝した人の末路");
		bookList.setBook_author("はせきょん");
		bookList.setBook_publisher("神山舎");
		bookList.setBook_releasetime("2022-11-11");
		bookService.createBook(bookList);

		//BookList targetlistBookLists = bookService.targetBook(13);

	}

	@Test
	@Disabled
	void editBook() {
		BookList bookList = new BookList();
		bookList.setBook_id(14);
		bookList.setBook_name("じゃんけんで200連勝した人の末路");
		bookList.setBook_author("はせきょんZ");
		bookList.setBook_publisher("神山舎EX");
		bookList.setBook_releasetime("2022-11-11");

		bookService.editBook(bookList);

	}

	@Test
	@Disabled
	void deleteBook() {
		bookService.deleteBook(11);
	}

	@Test
	//@Disabled
	void rentalreturnBook() {
		int book_id = 1;
		BookList lists = bookService.targetBook(book_id);
		System.out.println("在庫数" + lists.getStock());

		bookService.rentalBook(book_id);
		BookList rentald_lists = bookService.targetBook(book_id);
		System.out.println("貸し出し処理在庫数" + rentald_lists.getStock());

		System.out.println(lists.getStock() - 1);

		assertEquals(lists.getStock() - 1, rentald_lists.getStock());
		System.out.println("-----------------------------------");

		bookService.returnBook(book_id);
		BookList returnd_lists = bookService.targetBook(book_id);
		System.out.println("返却処理在庫数" + returnd_lists.getStock());

		assertEquals(lists.getStock(), returnd_lists.getStock());
		System.out.println("-----------------------------------");

	}
}
