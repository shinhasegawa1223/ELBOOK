package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.RentalMapper;

@Service
public class RentalService {
	
	@Autowired
	RentalMapper rentalMapper;

	public void rental(int book_id) {
		
		rentalMapper.rental(book_id);
	}
	

}
