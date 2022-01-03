package com.jmurphey.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmurphey.mvc.models.Book;
import com.jmurphey.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	// this method retrieves all the books from the database
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
		
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// delete a book
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	// update a book
	public Book alterBook(Long id, String title, String desc, String lang, Integer pages) {
		Book book = findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(pages);	
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	public Book retrieveBook(Long id) {
		return this.findBook(id);
	}
	



	
	

		
//		// this method finds books with a given description
//		List<Book> findByDescription(String description) {
//			return null;
//		}

//		// this method finds books with descriptions containing the search string
//		List<Book> findByDescriptionContaining(String search) {
//			return null;
//		}
		
//		// this method counts how many titles contain a certain string
//	    Long countByTitleContaining(String search) {
//			return null;
//		}
	    
//	    // this method deletes a book that starts with a specific title
//	    Long deleteByTitleStartingWith(String search) {
//			return null;
//		}
	    
//	    // this method finds an entity by its id
//	    Optional<Book> findById(Long id) {
//			return null;
//		}
//	    
//	    // this method finds a particular book by its title
//	    List<Book> findByTitle(String title) {
//			return null;
//		}
}
