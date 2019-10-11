package com.jbk.springauthor.PublicationManagement.author.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springauthor.PublicationManagement.author.entity.Author;

@Repository
public class AuthorDaoImpl implements AuthorDaoInterface{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		Session session =entityManager.unwrap(Session.class);
		
		//create query
		
		Query<Author> query=session.createQuery("from Author",Author.class);
		List<Author> author=query.getResultList();
		
		return author;
	}
	@Transactional
	@Override
	public Author findById(int aid) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		return author;
		
	}

	@Override
	public void save(Author author) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(author);
		
	}

	@Transactional
	@Override
	public void deleteById(int aid) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		currentSession.delete(author);
		
	}

	@Transactional
	@Override
	public void saveOrUpdate(Author author) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(author);
		
	}

}
