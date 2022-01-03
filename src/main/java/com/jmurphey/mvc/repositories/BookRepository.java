package com.jmurphey.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{ // Table/class Book, and Data type of our Id
	
	// this method retrieves all the books from the database
	List<Book> findAll();
	
	// this method finds an entity by its id
    Optional<Book> findById(Long id);
    
    
    //create method to update book
    
    
    //create method to delete book
//    void deleteById(Long id);
//    
    
	
//	// this method finds books with a given description
//	List<Book> findByDescription(String description);
//
//	// this method finds books with descriptions containing the search string
//	List<Book> findByDescriptionContaining(String search);
//	
//	// this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
    
//    // this method finds a particular book by its title
//    List<Book> findByTitle(String title);
    
}
