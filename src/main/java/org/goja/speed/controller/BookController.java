package org.goja.speed.controller;

import java.util.List;

import org.goja.speed.model.Book;
import org.goja.speed.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(method = RequestMethod.GET)
	List<Book> list() {
		return (List<Book>) bookRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	Book add(@RequestBody Book book) {
		book.setId(null);
		return bookRepository.save(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	Book update(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		return bookRepository.save(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Long id) {
		bookRepository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Book get(@PathVariable Long id) {
		return bookRepository.findOne(id);
	}

}
