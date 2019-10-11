package com.jbk.springauthor.PublicationManagement.author.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springauthor.PublicationManagement.author.dao.AuthorDaoImpl;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;


@Service
public class AuthorServiceImpl implements AuthorServiceInterface{
	
	@Autowired
	private AuthorDaoImpl authorDaoImpl;

	@Override
	@Transactional
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorDaoImpl.findAll();
	}

	@Transactional
	@Override
	public Author findById(int aid) {
		// TODO Auto-generated method stub
		return authorDaoImpl.findById(aid);

	}

	@Transactional
	@Override
	public void save(Author author) {
		// TODO Auto-generated method stub
		authorDaoImpl.save(author);
		
	}
	
	

	@Transactional
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		authorDaoImpl.deleteById(id);
	}

	@Override
	public void saveOrUpdate(Author author) {
		// TODO Auto-generated method stub
		authorDaoImpl.saveOrUpdate(author);
		
	}


}
