package com.jbk.springauthor.PublicationManagement.author.dao;

import java.util.List;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;


public interface AuthorDao {
	/* Method to find all authors */ 
	public List<Author> findAll();
	
	/* Method to find author by Id */
	public Author findById(int id);
	
	/* Method To Create new author */
	public void save(Author author);
	
	/* Method To Update Author */
	public void saveOrUpdate(Author author);
	
	/* Method To delete author by Id */
	public void deleteById(int id);

}
