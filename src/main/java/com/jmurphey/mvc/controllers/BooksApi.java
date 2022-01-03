package com.jmurphey.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmurphey.mvc.models.Book;
import com.jmurphey.mvc.services.BookService;



@RestController
public class BooksApi {
	@Autowired   // this annotation essentially does what the constructor below does. 
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
//	//@PostMapping ("/api/create")
//	public Book create(Book newBook) {
//		return bookService.createBook(newBook);
//	}
	
	
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title")String title, @RequestParam(value="description")String desc, 
			@RequestParam(value="language")String lang, @RequestParam("pages")Integer numOfPages) {
		
		Book book = new Book(title, desc,lang, numOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id")Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@RequestMapping("/api/books/delete/{id}")
	public void destroy(@PathVariable("id")Long id) {
		bookService.delete(id);
	}
	
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
		
        Book book = bookService.alterBook(id, title, desc, lang, numOfPages);
        return book;
    }
	
	
}
