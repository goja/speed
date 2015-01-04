package org.goja.speed.init;

import javax.annotation.PostConstruct;

import org.goja.speed.model.Book;
import org.goja.speed.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

	@Autowired
	private BookRepository bookRepository;

	@PostConstruct
	public void populate() {
		addNewBook("The Lord of the Rings", 12.0, "Tolkien");
		addNewBook("Pride and Prejudice", 10.19, "Jane Austin");
		addNewBook("Romeo and Juliet", 22.99, "William Shakespear");
		addNewBook("Of Mice and Men", 11.25, "John Stienback");
		addNewBook("The Adventures of Huckleberry Finn", 23.0, "Mark Twain");
		addNewBook("A Thousand Splendid Suns", 8.59, "Khalid Hosseini");
		addNewBook("A Tale of Two Cities", 9.0, "Charles Dickens");
		addNewBook("Catch-22", 5.99, "Joseph Heller");
		addNewBook("Atlas Shrugged", 11.29, "Ayn Rand");
		addNewBook("On the road", 7.89, "Jack Kerouac");
		addNewBook("And then there were None", 9.79, "Agatha Christie");
		addNewBook("Kane and Able", 11.39, "Jeffery Archer");
		addNewBook("To kill a Mockingbird", 10.0, "Harper Lee");
		addNewBook("The Godfather", 13.99, "Mario Puzo");
		addNewBook("Love Story", 8.99, "Eric Segal");
		addNewBook("Jaws", 11.59, "Peter Benchley");
		addNewBook("The Old Man and the Sea", 3.99, "Ernst Hemingway");
		addNewBook("Alice in Wonderland", 15.19, "Lewis Carroll");
		addNewBook("Gone with the Wind", 17.09, "Margaret Mitchell");
		addNewBook("Jane Eyre", 12.79, "Charlotte Bronte");
		addNewBook("Robinson Crusoe", 10.39, "Daniel Defoe");
		addNewBook("Silas Marner", 9.19, "George Elliot");
		addNewBook("The fault in our Stars", 8.99, "John Green");
		addNewBook("The Outsider", 7.89, "Albert Camus");
		addNewBook("The Call of the Wild", 6.59, "Jack London");
		addNewBook("Treasure Island", 10.11, "Robert Louis Stevenson");
	}

	private void addNewBook(String title, Double price, String author) {
		bookRepository.save(new Book(title, price, author));
	}
}
