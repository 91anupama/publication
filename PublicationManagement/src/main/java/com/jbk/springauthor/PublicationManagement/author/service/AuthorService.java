package com.jbk.springauthor.PublicationManagement.author.service;

import java.util.List;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;

public interface AuthorService {
	
	/* To find all authors */
	public List<Author> findAll();
	
	/* To find author by id */
	public Author findById(int id);
	
	/* To create new author */
	public void save(Author author);
	
	/* To update author */ 
	public void saveOrUpdate(Author author);
	
	/* To delete author by id */
	public void deleteById(int id);
	

}
