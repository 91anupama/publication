package com.jbk.springauthor.PublicationManagement.author.service;

import java.util.List;

import com.jbk.springauthor.PublicationManagement.author.entity.Author;

public interface AuthorServiceInterface {
	public List<Author> findAll();
	public Author findById(int id);
	public void save(Author author);
	public void saveOrUpdate(Author author);
	public void deleteById(int id);
	

}
