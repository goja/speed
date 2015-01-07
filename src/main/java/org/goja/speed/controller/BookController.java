package org.goja.speed.controller;

import org.goja.speed.model.Book;
import org.goja.speed.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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

	@RequestMapping(value = "/{sort}/{size}/{page}", method = RequestMethod.GET)
	Page<Book> list(@PathVariable String sort, @PathVariable Integer size, @PathVariable Integer page) {
		return (Page<Book>) bookRepository.findAll(new PageRequest(page, size, new Sort(new Order(Direction.ASC,
				sort))));
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
