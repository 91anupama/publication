package com.jbk.springauthor.PublicationManagement.author.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.springauthor.PublicationManagement.author.dao.AuthorDao;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Author> findAll() {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Query<Author> query = session.createQuery("from Author", Author.class);
		List<Author> author = query.getResultList();
		return author;
	}

	@Override
	public Author findById(int aid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		return author;

	}

	@Override
	public void save(Author author) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(author);

	}

	@Override
	public void deleteById(int aid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Author author = currentSession.get(Author.class, aid);
		currentSession.delete(author);

	}

	@Override
	public void saveOrUpdate(Author author) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(author);

	}

}
