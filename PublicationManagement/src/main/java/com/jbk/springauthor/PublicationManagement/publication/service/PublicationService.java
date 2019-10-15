package com.jbk.springauthor.PublicationManagement.publication.service;

import java.util.List;

import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

public interface PublicationService {

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
	
	//To get publication having particular author name

	public List<Publication> getPublicationWithAuthor(String author_name);
	
	//To get publication having particular author name and publication type

	public List<Publication> getPublicationWithAuthorType_p(String author_name, String type_pub);

	//To get publication having particular author name and publication type with sub_type
	public List<Publication> getPublicationWithAuthorType_p_sub_type(String author_name, String type_pub, String sub_type, String sub_type_val);

}
