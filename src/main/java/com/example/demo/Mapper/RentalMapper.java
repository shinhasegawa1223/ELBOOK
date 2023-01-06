package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RentalMapper {
	
	void rental(int book_id);

}
