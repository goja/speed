package org.goja.speed.repository;

import org.goja.speed.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
