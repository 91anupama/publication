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
	@Transactional
	public void deleteById(int pid) {
		publicationDao.deleteById(pid);

	}

	@Override
	public List<Publication> getPublicationWithAuthor(String author_name) {
		
		return publicationDao.getPublicationWithAuthor(author_name);
	}


	@Override
	public List<Publication> getPublicationWithAuthorType_p(String author_name, String type_pub) {
		
		return publicationDao.getPublicationWithAuthorType_p(author_name,type_pub);
	}

	@Override
	public List<Publication> getPublicationWithAuthorType_p_sub_type(String author_name, String type_pub,
			String sub_type,String sub_type_val) {
		return publicationDao.getPublicationWithAuthorType_p_sub_type(author_name,type_pub,sub_type,sub_type_val);
	}


}
