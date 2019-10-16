package com.jbk.springauthor.PublicationManagement.author.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.springauthor.PublicationManagement.author.dao.AuthorDao;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {
	private static  final Logger LOGGER =LoggerFactory.getLogger(AuthorDaoImpl.class);
			//	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Author> findAll() {
		LOGGER.info("Inside Author FindAll");
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Query<Author> query = session.createQuery("from Author", Author.class);
		List<Author> author = query.getResultList();
		return author;
	}

	@Override
	public Author findById(int aid) {
		LOGGER.info("Inside Author findById");
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		return author;

	}

	@Override
	public void save(Author author) {
		LOGGER.info("Inside Author save");
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(author);

	}

	@Override
	public void deleteById(int aid) {
		LOGGER.info("Inside Author deleteById");
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		currentSession.delete(author);

	}

	@Override
	public void saveOrUpdate(Author author) {
		LOGGER.info("Inside Author saveOrUpdate");
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(author);

	}

}
