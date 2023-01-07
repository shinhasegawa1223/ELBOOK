package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;
import com.example.demo.Service.RentalService;
import com.example.demo.Service.auth.CustomUserDetails;

import lombok.Data;

@Controller
@Data
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	RentalService rentalService;

	//アクセス時にユーザーを一覧で取得
	@GetMapping("/list")
	public String findBook(@AuthenticationPrincipal CustomUserDetails user_role, Model model) {
		model.addAttribute("BookList", bookService.findBook());
		//System.out.println(user_role);
		return "booklist";
	}

	@GetMapping("/editview/{book_id}")
	public String moveEditView(@PathVariable int book_id, Model model) {
		model.addAttribute("TargetBook", bookService.targetBook(book_id));
		return "bookedit";
	}

	@GetMapping("/createview")
	public String moveCreateView(Model model) {
		return "bookcreate";
	}

	@PostMapping("/bookcreate")
	public String createBook(@ModelAttribute("createBook") BookList bookList) {
		//System.out.println(bookList);
		bookService.createBook(bookList);
		return "redirect:/book/list";
	}

	@PostMapping("/bookedit")
	public String editBook(@ModelAttribute("editBook") BookList bookList) {
		System.out.println(bookList);
		bookService.editBook(bookList);
		return "redirect:/book/list";
	}

	@PostMapping("/rental/{book_id}")
	public String rental(@PathVariable int book_id) {
		System.out.println(book_id);
		rentalService.rental(book_id);
		return "redirect:/book/list";
	}

	@GetMapping("/bookdelete/{book_id}")
	public String deleteBook(@PathVariable int book_id) {
		//System.out.println(book_id);
		bookService.deleteBook(book_id);
		return "redirect:/book/list";
	}

	@GetMapping("/details/{book_id}")
	public String details(@PathVariable int book_id, Model model) {
		model.addAttribute("TargetBook", bookService.targetBook(book_id));
		return "bookdetails";
	}

}
