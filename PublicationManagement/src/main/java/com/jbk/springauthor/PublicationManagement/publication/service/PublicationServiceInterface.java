package com.jbk.springauthor.PublicationManagement.publication.service;

import java.util.List;

import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

public interface PublicationServiceInterface {
	public List<Publication> findAll();
	public Publication findById(int id);
	public void save(Publication publication);
	public void deleteById(int id);
	public void saveorupdate(Publication publication);

}
