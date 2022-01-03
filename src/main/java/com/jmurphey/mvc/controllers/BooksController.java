package com.jmurphey.mvc.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmurphey.mvc.models.Book;
import com.jmurphey.mvc.services.BookService;


@Controller
@RequestMapping("/books")
public class BooksController {

	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	
	@GetMapping("")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	
	@GetMapping("/show/{id}")
	public String showBook(@PathVariable Long id, Model model) {
		
		model.addAttribute("book", this.bookService.retrieveBook(id));
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", this.bookService.retrieveBook(id));
		return "edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("/{id}")
	public String destroy(@PathVariable Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
	
	
}
