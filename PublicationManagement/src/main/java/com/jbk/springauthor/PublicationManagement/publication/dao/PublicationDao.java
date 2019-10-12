package com.jbk.springauthor.PublicationManagement.publication.dao;

import java.util.List;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

public interface PublicationDao {
	
	/* To find all publications */
	public List<Publication> findAll();
	
	/* To find publication by id */
	public Publication findById(int id);
	
	/* To create new publication */
	public void save(Publication publication);
	
	/* To delete publication by id */
	public void deleteById(int id);
	
	/* To update publication */
	public void saveorupdate(Publication publication);


}
