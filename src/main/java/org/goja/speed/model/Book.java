package org.goja.speed.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 3961711068389356102L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private String author;

	public Book() {
	}

	public Book(String title, Double price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
