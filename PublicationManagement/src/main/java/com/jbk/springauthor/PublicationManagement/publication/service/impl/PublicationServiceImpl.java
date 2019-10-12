package com.jbk.springauthor.PublicationManagement.publication.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jbk.springauthor.PublicationManagement.publication.dao.PublicationDao;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;
import com.jbk.springauthor.PublicationManagement.publication.service.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationDao publicationDao;

	@Override
	public List<Publication> findAll() {
		return publicationDao.findAll();
	}

	@Override
	public Publication findById(int pid) {
		return publicationDao.findById(pid);
	}

	@Override
	@Transactional
	public void save(Publication publication) {
		publicationDao.save(publication);
	}

	@Override
	@Transactional
	public void saveorupdate(Publication publication) {
		publicationDao.saveorupdate(publication);

	}

	@Override
	public void deleteById(int pid) {
		publicationDao.deleteById(pid);

	}

}
