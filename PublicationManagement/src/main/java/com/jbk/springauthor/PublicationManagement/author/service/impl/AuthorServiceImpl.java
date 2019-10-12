package com.jbk.springauthor.PublicationManagement.author.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jbk.springauthor.PublicationManagement.author.dao.AuthorDao;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.author.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}

	@Override
	public Author findById(int aid) {
		return authorDao.findById(aid);

	}

	@Transactional
	@Override
	public void save(Author author) {
		authorDao.save(author);
	}

	@Override
	public void deleteById(int id) {
		authorDao.deleteById(id);
	}

	@Transactional
	@Override
	public void saveOrUpdate(Author author) {
		authorDao.saveOrUpdate(author);

	}

}
