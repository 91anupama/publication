package com.jbk.springauthor.PublicationManagement.publication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springauthor.PublicationManagement.publication.dao.PublicationDaoImpl;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

@Service
public class PublicationServiceImpl implements PublicationServiceInterface {

	@Autowired
	private PublicationDaoImpl publicationDaoImpl;

	@Override
	@Transactional
	public List<Publication> findAll() {
		return publicationDaoImpl.findAll();
	}

	@Override
	@Transactional
	public Publication findById(int pid) {

		return publicationDaoImpl.findById(pid);
	}

	@Override
	@Transactional
	public void save(Publication publication) {
		publicationDaoImpl.save(publication);
	}

	@Override
	@Transactional
	public void saveorupdate(Publication publication) {
		publicationDaoImpl.saveorupdate(publication);

	}

	@Override
	@Transactional
	public void deleteById(int pid) {
		
		publicationDaoImpl.deleteById(pid);

	}

}
