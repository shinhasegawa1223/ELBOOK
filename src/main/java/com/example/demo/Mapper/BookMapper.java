package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.BookList;

@Mapper
public interface BookMapper {

	List<BookList> findBook();

	BookList targetBook(int book_id);

	void createBook(BookList bookList);

	void editBook(BookList bookList);

	void deleteBook(int book_id);

	int getMaxNumberBook();

}
